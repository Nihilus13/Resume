package com.nihilus13.ui.resume.adapter.binders

import android.view.ViewGroup
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.resume.R
import com.nihilus13.resume.databinding.RecyclerSkillBinding
import org.junit.Test

class SkillViewHolderBinderTest {

    private val skillViewGroupMock = mock<ViewGroup> {
        on { context } doReturn (mock())
    }
    private val skillBindingMock = mock<RecyclerSkillBinding> {
        on { root } doReturn mock()
        on { root.context } doReturn mock()
        on { root.context.resources } doReturn mock()
        on { root.context.resources.getDimension(R.dimen.margin_small) } doReturn 0f
    }
    private val inflateBindingMock = mock<(ViewGroup) -> RecyclerSkillBinding> {
        on { invoke(skillViewGroupMock) } doReturn skillBindingMock
    }
    private val tested = SkillViewHolderBinder(inflateBindingMock)

    @Test
    fun `creates view holder`() {
        tested.createViewHolder(skillViewGroupMock)

        verify(inflateBindingMock).invoke(skillViewGroupMock)
    }
}