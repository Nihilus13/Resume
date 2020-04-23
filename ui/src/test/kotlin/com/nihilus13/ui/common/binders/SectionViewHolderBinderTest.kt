package com.nihilus13.ui.common.binders

import android.view.ViewGroup
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.resume.databinding.RecyclerSectionBinding
import org.junit.Test

class SectionViewHolderBinderTest {

    private val sectionViewGroupMock = mock<ViewGroup> {
        on { context } doReturn (mock())
    }
    private val sectionBindingMock = mock<RecyclerSectionBinding> {
        on { root } doReturn mock()
    }
    private val inflateBindingMock = mock<(ViewGroup) -> RecyclerSectionBinding> {
        on { invoke(sectionViewGroupMock) } doReturn sectionBindingMock
    }
    private val tested = SectionViewHolderBinder(inflateBindingMock)

    @Test
    fun `creates view holder`() {
        tested.createViewHolder(sectionViewGroupMock)

        verify(inflateBindingMock).invoke(sectionViewGroupMock)
    }
}