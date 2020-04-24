package com.nihilus13.ui.resume.adapter

import androidx.databinding.ViewDataBinding
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nihilus13.resume.R
import com.nihilus13.ui.common.binders.ViewHolderBinder
import com.nihilus13.ui.common.holders.AbstractViewHolder
import com.nihilus13.uimodels.ResumeItem
import com.nihilus13.uimodels.SectionResumeItem
import org.junit.Assert.assertEquals
import org.junit.Test

class ResumeAdapterTest {
    private val viewTypeForMockedBinder = 0
    private val resumeItemMock: ResumeItem = mock()

    private val binderMock: ViewHolderBinder<CustomViewHolder, ResumeItem, ViewDataBinding> = mock {
        on { getViewHolderType() } doReturn viewTypeForMockedBinder
        on { isInstanceOfBinder(resumeItemMock) } doReturn true
    }
    private val tested = ResumeAdapter(setOf(binderMock))

    @Test
    fun `returns correct number of items`() {
        tested.listCombined = mutableListOf(
            SectionResumeItem(R.string.section_job),
            SectionResumeItem(R.string.section_job)
        )

        val actual = tested.itemCount

        assertEquals(
            "adapter items amount should be correct, but it is not", 2, actual
        )
    }

    @Test
    fun `binds view holder with correct data`() {
        tested.listCombined = mutableListOf(resumeItemMock)
        val viewHolder = CustomViewHolder(mock())

        tested.onBindViewHolder(viewHolder, 0)

        assertEquals(
            "adapter should bind view holder with correct data but is not",
            resumeItemMock,
            viewHolder.resumeItem
        )
    }

    @Test
    fun `returns correct view type for handled binder`() {
        tested.listCombined = mutableListOf(resumeItemMock)

        val viewType = tested.getItemViewType(0)

        assertEquals(
            "adapter should get",
            viewTypeForMockedBinder,
            viewType
        )
    }

    @Test(expected = NoSuchElementException::class)
    fun `fails on unhandled binder`() {
        tested.listCombined = mutableListOf(
            SectionResumeItem(R.string.section_job)
        )
        tested.getItemViewType(0)
    }
}

class CustomViewHolder(private val binding: ViewDataBinding) : AbstractViewHolder<ResumeItem>(
    mock { on { binding.root } doReturn (mock()) }
) {

    var resumeItem: ResumeItem? = null

    override fun bindViewHolder(item: ResumeItem) {
        this.resumeItem = item
    }
}