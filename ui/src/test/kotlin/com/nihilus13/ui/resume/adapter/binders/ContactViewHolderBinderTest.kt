package com.nihilus13.ui.resume.adapter.binders

import android.view.ViewGroup
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.resume.databinding.RecyclerContactBinding
import com.nihilus13.ui.resume.adapter.onclick.OnDataBindViewClick
import org.junit.Test

class ContactViewHolderBinderTest {

    private val contactViewGroupMock = mock<ViewGroup> {
        on { context } doReturn (mock())
    }
    private val contactBindingMock = mock<RecyclerContactBinding> {
        on { root } doReturn (mock())
    }
    private val onContactMock: OnDataBindViewClick = mock()
    private val inflateBindingMock = mock<(ViewGroup) -> RecyclerContactBinding> {
        on { invoke(contactViewGroupMock) } doReturn contactBindingMock
    }
    private val tested =
        ContactViewHolderBinder(onContactMock, onContactMock, onContactMock, inflateBindingMock)

    @Test
    fun `creates view holder`() {
        tested.createViewHolder(contactViewGroupMock)

        verify(inflateBindingMock).invoke(contactViewGroupMock)
    }
}