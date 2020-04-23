package com.nihilus13.ui.resume.adapter.binders

import android.view.ViewGroup
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.resume.R
import com.nihilus13.resume.databinding.RecyclerJobExperienceBinding
import org.junit.Test

class JobExperienceViewHolderBinderTest {
    private val jobExperienceViewGroupMock = mock<ViewGroup> {
        on { context } doReturn (mock())
    }
    private val jobExperienceBindingMock = mock<RecyclerJobExperienceBinding> {
        on { root } doReturn mock()
        on { root.context } doReturn mock()
        on { root.context.resources } doReturn mock()
        on { root.context.resources.getDimension(R.dimen.margin_small) } doReturn 0f
    }
    private val inflateBindingMock = mock<(ViewGroup) -> RecyclerJobExperienceBinding> {
        on { invoke(jobExperienceViewGroupMock) } doReturn jobExperienceBindingMock
    }
    private val tested = JobExperienceViewHolderBinder(inflateBindingMock)

    @Test
    fun `creates view holder`() {
        tested.createViewHolder(jobExperienceViewGroupMock)

        verify(inflateBindingMock).invoke(jobExperienceViewGroupMock)
    }
}