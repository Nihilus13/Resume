package com.nihilus13.data.repository.datasource.cached

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.domain.model.Contact
import com.nihilus13.domain.model.Person
import com.nihilus13.domain.model.Resume
import org.junit.After
import org.junit.Rule
import org.junit.Test

class CachedResumeDataSourceImplTest {
    private val tested = CachedResumeDataSourceImpl()

    private val resume = Resume(Person("", ""), Contact("", "", ""))
    private val observerMock: Observer<Resume?> = mock()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun `shoud refresh cached data source`() {
        tested.getResumeObservable().observeForever(observerMock)

        tested.refresh(resume)

        verify(observerMock).onChanged(resume)
    }

    @After
    fun clearObservableFromObservers() {
        tested.getResumeObservable().removeObserver(observerMock)
    }
}