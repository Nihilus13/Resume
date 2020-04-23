package com.nihilus13.ui.resume.adapter.binders

import android.view.ViewGroup
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.resume.R
import com.nihilus13.resume.databinding.RecyclerPersonBinding
import org.junit.Test

class PersonViewHolderBinderTest {
    private val personViewGroupMock = mock<ViewGroup> {
        on { context } doReturn (mock())
    }
    private val personBindingMock = mock<RecyclerPersonBinding> {
        on { root } doReturn mock()
        on { root.context } doReturn mock()
        on { root.context.resources } doReturn mock()
        on { root.context.resources.getDimension(R.dimen.margin_small) } doReturn 0f
    }
    private val inflateBindingMock = mock<(ViewGroup) -> RecyclerPersonBinding> {
        on { invoke(personViewGroupMock) } doReturn personBindingMock
    }
    private val tested = PersonViewHolderBinder(inflateBindingMock)

    @Test
    fun `creates view holder`() {
        tested.createViewHolder(personViewGroupMock)

        verify(inflateBindingMock).invoke(personViewGroupMock)
    }
}