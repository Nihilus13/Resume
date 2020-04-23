package com.nihilus13.ui.resume

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.domain.usecase.FetchResumeUseCase
import com.nihilus13.domain.usecase.ResumeState
import com.nihilus13.ui.resume.observer.ResumeStateObserver
import org.junit.Rule
import org.junit.Test

class ResumeViewModelTest {
    private val liveDataMock: MutableLiveData<ResumeState> = mock()
    private val observerMock: ResumeStateObserver = mock()
    private val fetchResumeUseCaseMock: FetchResumeUseCase = mock {
        on { state } doReturn liveDataMock
    }

    private val tested = ResumeViewModel(fetchResumeUseCaseMock, observerMock)

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun `fetches resume`() {
        tested.fetchResume()

        verify(fetchResumeUseCaseMock).fetchResume(tested.viewModelScope)
    }

    @Test
    fun `starts observing fetch resume use case`() {
        tested.start()

        verify(liveDataMock).observeForever(observerMock)
    }

    @Test
    fun `stops observing fetch resume use case`() {
        tested.stop()

        verify(liveDataMock).removeObserver(observerMock)
    }
}