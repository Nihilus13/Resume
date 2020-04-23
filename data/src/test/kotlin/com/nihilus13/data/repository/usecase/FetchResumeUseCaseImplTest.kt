package com.nihilus13.data.repository.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.coroutines.scope.TestScope
import com.nihilus13.coroutines.scope.TestableCoroutineScope
import com.nihilus13.domain.repository.ResumeRepository
import com.nihilus13.domain.usecase.FetchResumeHandler
import com.nihilus13.domain.usecase.ResumeState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FetchResumeUseCaseImplTest {
    private val testDispatcher = TestCoroutineDispatcher()
    private val scopeTransformer: (CoroutineScope) -> TestableCoroutineScope =
        { TestScope(testDispatcher) }

    private val resumeRepositoryMock: ResumeRepository = mock {
        on { getResumeObservable() } doReturn mock()
    }
    private val coroutineScope: CoroutineScope = mock()

    private val responseHandlerMock: FetchResumeHandler = mock()

    private val observerMock: Observer<ResumeState> = mock()

    private val tested =
        FetchResumeUseCaseImpl(scopeTransformer, resumeRepositoryMock, responseHandlerMock)

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `starts fetching resume with state loading`() {
        runBlocking {
            tested.state.observeForever(observerMock)

            tested.fetchResume(coroutineScope)

            verify(observerMock).onChanged(ResumeState.Loading)
        }
    }

    @Test
    fun `starts fetching resume from repository`() {
        runBlocking {
            tested.fetchResume(coroutineScope)

            verify(responseHandlerMock).handleResumeResponse()
        }
    }

    @After
    fun clearObservableFromObservers() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
        tested.state.removeObserver(observerMock)
    }
}