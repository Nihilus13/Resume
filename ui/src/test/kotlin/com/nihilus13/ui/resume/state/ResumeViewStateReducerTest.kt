package com.nihilus13.ui.resume.state

import com.nhaarman.mockitokotlin2.mock
import com.nihilus13.domain.model.Contact
import com.nihilus13.domain.model.Person
import com.nihilus13.domain.model.Resume
import com.nihilus13.domain.usecase.ResumeState
import com.nihilus13.transformer.DataToResumeItemTransformer
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ResumeViewStateReducerTest {

    private val viewState = ViewState()
    private val mockTransformer: DataToResumeItemTransformer<Resume> = mock()

    private val tested = ResumeViewStateReducer(mockTransformer)

    @Test
    fun `produces data state without error`() {
        val resume = Resume(Person("", ""), Contact("", "", ""))

        val newViewState = tested.reduce(
            viewState,
            ResumeState.ResumeData(
                resume
            )
        )

        assertFalse(
            "State has error, but should not!",
            newViewState.hasError
        )
    }

    @Test
    fun `produces data state without loading`() {
        val resume = Resume(Person("", ""), Contact("", "", ""))
        val newViewState = tested.reduce(
            viewState,
            ResumeState.ResumeData(
                resume
            )
        )

        assertFalse(
            "State is loading, but should not!",
            newViewState.loading
        )
    }

    @Test
    fun `produces error state with empty resume`() {
        val actual = tested.reduce(
            viewState,
            ResumeState.Error
        )

        assertTrue(
            "ResumeItem list is not empty, but it should!",
            actual.listResume.isEmpty()
        )
    }

    @Test
    fun `produces error state`() {
        val actual = tested.reduce(
            viewState,
            ResumeState.Error
        )

        assertTrue(
            "State does not have an error, but should!",
            actual.hasError
        )
        assertFalse(
            "State is loading, but should not!",
            actual.loading
        )
    }

    @Test
    fun `produces error state without loading`() {
        val actual = tested.reduce(
            viewState,
            ResumeState.Error
        )

        assertFalse(
            "State is loading, but should not!",
            actual.loading
        )
    }

}