package com.nihilus13.ui.common.holders

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.resume.R
import com.nihilus13.resume.databinding.RecyclerSectionBinding
import com.nihilus13.uimodels.SectionResumeItem
import org.junit.Test

class SectionViewHolderTest {
    private val sectionindingMock = mock<RecyclerSectionBinding> {
        on { root } doReturn (mock())
    }
    private val sectionItem = SectionResumeItem(R.string.section_job)
    private val tested = SectionViewHolder(sectionindingMock)

    @Test
    fun `binds section`() {
        tested.bindViewHolder(sectionItem)

        verify(sectionindingMock).sectionResumeItem = sectionItem
    }
}