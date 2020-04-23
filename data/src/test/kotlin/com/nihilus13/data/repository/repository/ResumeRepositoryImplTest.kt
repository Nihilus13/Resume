package com.nihilus13.data.repository.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.data.repository.datasource.CachedResumeDataSource
import com.nihilus13.data.repository.datasource.RemoteResumeDataSource
import com.nihilus13.domain.model.Contact
import com.nihilus13.domain.model.Person
import com.nihilus13.domain.model.Resume
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class ResumeRepositoryImplTest {
    private val remoteResumeDataSourceMock: RemoteResumeDataSource = mock()
    private val cachedResumeDataSourceMock: CachedResumeDataSource = mock()
    private val resume = Resume(Person("", ""), Contact("", "", ""))

    private val tested =
        ResumeRepositoryImpl(remoteResumeDataSourceMock, cachedResumeDataSourceMock)

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun `fetches resume`() {
        runBlocking {
            tested.fetchResume()

            verify(remoteResumeDataSourceMock).fetchResume()
        }
    }

    @Test
    fun `refreshes resume`() {
        tested.refreshResume(resume)

        verify(cachedResumeDataSourceMock).refresh(resume)
    }

    @Test
    fun `returns resume observable`() {
        tested.getResumeObservable()

        verify(cachedResumeDataSourceMock).getResumeObservable()
    }
}