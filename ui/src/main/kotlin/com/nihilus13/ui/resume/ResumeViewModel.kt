package com.nihilus13.ui.resume

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nihilus13.data.repository.usecase.FetchResumeUseCaseImpl
import com.nihilus13.domain.usecase.FetchResumeUseCase
import com.nihilus13.ui.resume.observer.ResumeStateObserver
import com.nihilus13.ui.resume.observer.ResumeStateObserverImpl
import com.nihilus13.ui.resume.state.ResumeViewStateReducer
import com.nihilus13.ui.resume.state.ViewState

class ResumeViewModel internal constructor(
    private val fetchResumeUseCase: FetchResumeUseCase,
    private val observer: ResumeStateObserver
) :
    ViewModel() {
    constructor() : this(
        FetchResumeUseCaseImpl(),
        ResumeStateObserverImpl(ResumeViewStateReducer())
    )

    val viewState: ViewState = observer.viewState

    fun fetchResume() = fetchResumeUseCase.fetchResume(viewModelScope)

    fun start() = fetchResumeUseCase.state.observeForever(observer)

    fun stop() {
        with(fetchResumeUseCase) {
            state.removeObserver(observer)
            onClear()
        }
    }
}