package com.nihilus13.ui.resume.adapter.binders

import android.view.ViewGroup
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.resume.R
import com.nihilus13.resume.databinding.RecyclerEducationBinding
import org.junit.Test

class EducationViewHolderBinderTest {

    private val educationViewGroupMock = mock<ViewGroup> {
        on { context } doReturn (mock())
    }
    private val educationBindingMock = mock<RecyclerEducationBinding> {
        on { root } doReturn mock()
        on { root.context } doReturn mock()
        on { root.context.resources } doReturn mock()
        on { root.context.resources.getDimension(R.dimen.margin_small) } doReturn 0f
    }
    private val inflateBindingMock = mock<(ViewGroup) -> RecyclerEducationBinding> {
        on { invoke(educationViewGroupMock) } doReturn educationBindingMock
    }
    private val tested = EducationViewHolderBinder(inflateBindingMock)

    @Test
    fun `creates view holder`() {
        tested.createViewHolder(educationViewGroupMock)

        verify(inflateBindingMock).invoke(educationViewGroupMock)
    }
}