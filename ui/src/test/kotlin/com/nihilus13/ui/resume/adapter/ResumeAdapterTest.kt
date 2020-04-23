package com.nihilus13.ui.resume.adapter

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nihilus13.domain.model.*
import com.nihilus13.resume.R
import com.nihilus13.ui.common.holders.SectionViewHolder
import com.nihilus13.uimodels.*
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class ResumeAdapterTest {

    private val tested = ResumeAdapter(mock())
    private val resumeItemMock: ResumeItem = mock()

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
        val viewHolder = ViewHolderSpy()

        tested.onBindViewHolder(viewHolder, 0)

        assertEquals(
            "adapter should bind view holder with correct data but is not",
            resumeItemMock,
            viewHolder.resumeItem
        )
    }

    @Test
    fun `returns correct view type for section`() {
        tested.listCombined = mutableListOf(
            SectionResumeItem(R.string.section_job)
        )
        val viewType = tested.getItemViewType(0)

        assertEquals(
            "adapter should get",
            R.layout.recycler_section,
            viewType
        )
    }

    @Test
    fun `returns other view type for person`() {
        tested.listCombined = mutableListOf(
            PersonResumeItem(Person("", ""))
        )

        val viewType = tested.getItemViewType(0)

        assertEquals(R.layout.recycler_person, viewType)
    }

    @Test
    fun `returns other view type for contact`() {
        tested.listCombined = mutableListOf(
            ContactResumeItem(Contact("", "", ""))
        )

        val viewType = tested.getItemViewType(0)

        assertEquals(R.layout.recycler_contact, viewType)
    }

    @Test
    fun `returns other view type for job experience`() {
        tested.listCombined = mutableListOf(
            JobExperienceResumeItem(
                JobExperience(
                    Period(Date(), Date()),
                    Company("", "", ""),
                    ""
                )
            )
        )

        val viewType = tested.getItemViewType(0)

        assertEquals(R.layout.recycler_job_experience, viewType)
    }

    @Test
    fun `returns other view type for education`() {
        tested.listCombined = mutableListOf(
            EducationResumeItem(
                Education(Period(Date(), Date()), "", "", "", "")
            )
        )

        val viewType = tested.getItemViewType(0)

        assertEquals(R.layout.recycler_education, viewType)
    }

    @Test
    fun `returns other view type for skill`() {
        tested.listCombined = mutableListOf(SkillResumeItem(Skill("", "")))

        val viewType = tested.getItemViewType(0)

        assertEquals(R.layout.recycler_skill, viewType)
    }
}

class ViewHolderSpy : SectionViewHolder(
    mock { on { root } doReturn (mock()) }
) {

    var resumeItem: ResumeItem? = null

    override fun bindViewHolder(item: ResumeItem) {
        this.resumeItem = item
    }
}