package com.nihilus13.data.repository.usecase

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.nihilus13.domain.model.Contact
import com.nihilus13.domain.model.Person
import com.nihilus13.domain.model.Resume
import com.nihilus13.domain.repository.ResumeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.exceptions.base.MockitoException

class FetchResumeHandlerImplTest {
    private val resume: Resume = Resume(Person("", ""), Contact("", "", ""))

    private val resumeRepositoryMock: ResumeRepository = mock()

    private val tested = FetchResumeHandlerImpl(resumeRepositoryMock)

    @Test
    fun `handles repository response success`() {
        runBlocking {
            whenever(resumeRepositoryMock.fetchResume()).thenReturn(resume)

            tested.handleResumeResponse()

            verify(resumeRepositoryMock).refreshResume(resume)
        }
    }

    @Test
    fun `handles repository response error`() {
        runBlocking {
            whenever(resumeRepositoryMock.fetchResume()).thenThrow(MockitoException("some exception"))

            tested.handleResumeResponse()

            verify(resumeRepositoryMock).refreshResume(null)
        }
    }
}