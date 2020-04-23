package com.nihilus13.ui.resume.adapter.holders

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.domain.model.Contact
import com.nihilus13.resume.databinding.RecyclerContactBinding
import com.nihilus13.ui.resume.adapter.onclick.OnDataBindViewClick
import com.nihilus13.uimodels.ContactResumeItem
import org.junit.Test

class ContactViewHolderTest {

    private val contactBindingMock = mock<RecyclerContactBinding> {
        on { root } doReturn (mock())
    }

    private val clickMock: OnDataBindViewClick = mock()
    private val contactItem = ContactResumeItem(Contact("", "", ""))

    private val tested = ContactViewHolder(clickMock, clickMock, clickMock, contactBindingMock)

    @Test
    fun `binds contact`() {
        tested.bindViewHolder(contactItem)

        verify(contactBindingMock).contactResumeItem = contactItem
    }

    @Test
    fun `binds on phone click listener`() {
        tested.bindViewHolder(contactItem)

        verify(contactBindingMock).onPhoneClicklistener = clickMock
    }

    @Test
    fun `binds on mail click listener`() {
        tested.bindViewHolder(contactItem)

        verify(contactBindingMock).onMailClicklistener = clickMock
    }

    @Test
    fun `binds on linkedin click listener`() {
        tested.bindViewHolder(contactItem)

        verify(contactBindingMock).onLinkedInClicklistener = clickMock
    }

}