package com.nihilus13.ui.resume.adapter.holders

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.domain.model.Person
import com.nihilus13.imageloader.TransformationType
import com.nihilus13.resume.databinding.RecyclerPersonBinding
import com.nihilus13.uimodels.PersonResumeItem
import org.junit.Test

class PersonViewHolderTest {
    private val personBindingMock = mock<RecyclerPersonBinding> {
        on { root } doReturn (mock())
    }

    private val personItem = PersonResumeItem(
        Person("", "")
    )
    private val transforamtionMock: TransformationType = mock()

    private val tested = PersonViewHolder(personBindingMock, transforamtionMock)

    @Test
    fun `binds person`() {
        tested.bindViewHolder(personItem)

        verify(personBindingMock).personResumeItem = personItem
    }

    @Test
    fun `binds transformation`() {
        tested.bindViewHolder(personItem)

        verify(personBindingMock).transformation = transforamtionMock
    }
}