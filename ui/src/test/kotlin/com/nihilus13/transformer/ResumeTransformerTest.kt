package com.nihilus13.transformer

import com.nihilus13.domain.model.*
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class ResumeTransformerTest {

    private val tested = ResumeTransformer()

    private val resume: Resume = Resume(Person("", ""), Contact("", "", ""))

    @Test
    fun `prepares resume with person and contact`() {
        val result = tested.prepareResumeItemList(resume)

        assertEquals(3, result.size)
    }

    @Test
    fun `prepares resume with person, contact and one education`() {
        val resumeCopy =
            resume.copy(listEducation = listOf(Education(Period(Date(), Date()), "", "", "", "")))

        val result = tested.prepareResumeItemList(resumeCopy)

        assertEquals(5, result.size)
    }

    @Test
    fun `prepares resume with person, contact, one education and one job exp`() {
        val resumeCopy =
            resume.copy(
                listEducation = listOf(Education(Period(Date(), Date()), "", "", "", "")),
                listJobExperience = listOf(
                    JobExperience(Period(Date(), Date()), Company("", "", ""), "")
                )
            )

        val result = tested.prepareResumeItemList(resumeCopy)

        assertEquals(7, result.size)
    }

    @Test
    fun `prepares resume with person, contact, one education, one job exp and one skill`() {
        val resumeCopy =
            resume.copy(
                listEducation = listOf(Education(Period(Date(), Date()), "", "", "", "")),
                listJobExperience = listOf(
                    JobExperience(Period(Date(), Date()), Company("", "", ""), "")
                ),
                listSkill = listOf(Skill("", ""))
            )

        val result = tested.prepareResumeItemList(resumeCopy)

        assertEquals(9, result.size)
    }
}