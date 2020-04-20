package com.nihilus13.domain.usecase

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope

interface FetchResumeUseCase {
    val state: LiveData<ResumeState>
    fun fetchResume(coroutinesScope: CoroutineScope)
    fun onClear()
}

interface FetchResumeHandler {
    suspend fun handleResumeResponse()
}