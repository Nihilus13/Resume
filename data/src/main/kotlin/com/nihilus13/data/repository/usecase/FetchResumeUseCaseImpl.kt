package com.nihilus13.data.repository.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.nihilus13.coroutines.scope.LifecycleScope
import com.nihilus13.coroutines.scope.TestableCoroutineScope
import com.nihilus13.data.repository.repository.ResumeRepositoryProvider.getRestaurantRepository
import com.nihilus13.domain.repository.ResumeRepository
import com.nihilus13.domain.usecase.FetchResumeHandler
import com.nihilus13.domain.usecase.FetchResumeUseCase
import com.nihilus13.domain.usecase.ResumeState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

class FetchResumeUseCaseImpl internal constructor(
    private val scopeTransformer: (CoroutineScope) -> TestableCoroutineScope,
    private val resumeRepository: ResumeRepository,
    private val responseHandler: FetchResumeHandler
) :
    FetchResumeUseCase {
    constructor() : this(
        { LifecycleScope(it) },
        getRestaurantRepository(),
        FetchResumeHandlerImpl(getRestaurantRepository())
    )

    private var getResumeJob: Job? = null

    private val _state = MediatorLiveData<ResumeState>()
        .apply {
            postValue(ResumeState.Loading)
            addSource(resumeRepository.getResumeObservable()) {
                val newResumeState = if (it != null) {
                    ResumeState.ResumeData(it)
                } else {
                    ResumeState.Error
                }
                postValue(newResumeState)
            }
        }

    override val state: LiveData<ResumeState> = _state

    override fun fetchResume(coroutinesScope: CoroutineScope) {
        _state.value = ResumeState.Loading
        handleResponse(coroutinesScope)
    }

    private fun handleResponse(coroutinesScope: CoroutineScope) {
        getResumeJob?.cancel()
        getResumeJob = scopeTransformer(coroutinesScope).launch {
            responseHandler.handleResumeResponse()
        }
    }

    override fun onClear() {
        getResumeJob?.cancel()
    }
}