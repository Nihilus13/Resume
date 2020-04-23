package com.nihilus13.ui.resume.observer

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.nihilus13.domain.usecase.ResumeState
import com.nihilus13.ui.resume.state.ViewState
import com.nihilus13.ui.resume.state.reducer.ViewStateReducer
import org.junit.Test
import kotlin.test.assertEquals

class ResumeStateObserverImplTest {

    private val reducerMock: ViewStateReducer<ViewState, ResumeState> = mock()

    private val tested = ResumeStateObserverImpl(reducerMock)

    @Test
    fun `applies changes to viewState `() {
        val resumeState = ResumeState.Error
        val viewsStateModified = ViewState().apply {
            loading = false
            hasError = true
        }
        whenever(reducerMock.reduce(tested.viewState, resumeState)).thenReturn(viewsStateModified)

        tested.onChanged(resumeState)

        //It should be comparison of single object because reducer modifies original view state, and reference is the same. In this case mocked reducer return modified value, so in this case we can compare variables. It is not reducer test so we can mock this behaviour.
        assertEquals(
            viewsStateModified.hasError,
            tested.viewState.hasError,
            "view state should be modified correctly but it wasn't "
        )
        assertEquals(
            viewsStateModified.loading,
            tested.viewState.loading,
            "view state should be modified correctly but it wasn't "
        )
        assertEquals(
            viewsStateModified.listResume,
            tested.viewState.listResume,
            "view state should be modified correctly but it wasn't "
        )
    }

}