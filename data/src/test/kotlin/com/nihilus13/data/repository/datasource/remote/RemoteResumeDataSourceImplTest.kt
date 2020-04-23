package com.nihilus13.data.repository.datasource.remote

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.data.repository.api.ApiService
import com.nihilus13.domain.model.Contact
import com.nihilus13.domain.model.Person
import com.nihilus13.domain.model.Resume
import kotlinx.coroutines.runBlocking
import org.junit.Test

class RemoteResumeDataSourceImplTest {

    private val resume: Resume = Resume(Person("", ""), Contact("", "", ""))

    private val apiMock = mock<ApiService> {
        onBlocking { fetchResume() } doReturn resume
    }

    private val tested = RemoteResumeDataSourceImpl(apiMock)

    @Test
    fun `returns resume`() {
        runBlocking {
            val result = tested.fetchResume()

            verify(apiMock).fetchResume()
        }
    }

}