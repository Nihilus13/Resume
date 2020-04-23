package com.nihilus13.ui.resume.adapter.holders

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.domain.model.Company
import com.nihilus13.domain.model.JobExperience
import com.nihilus13.domain.model.Period
import com.nihilus13.imageloader.TransformationType
import com.nihilus13.resume.databinding.RecyclerJobExperienceBinding
import com.nihilus13.uimodels.JobExperienceResumeItem
import org.junit.Test
import java.util.*

class JobExperienceViewHolderTest {

    private val jobBindingMock = mock<RecyclerJobExperienceBinding> {
        on { root } doReturn (mock())
    }
    private val jobExperienceItem =
        JobExperienceResumeItem(JobExperience(Period(Date(), Date()), Company("", "", ""), ""))
    private val transforamtionMock: TransformationType = mock()

    private val tested = JobExperienceViewHolder(jobBindingMock, transforamtionMock)

    @Test
    fun `binds job experience`() {
        tested.bindViewHolder(jobExperienceItem)

        verify(jobBindingMock).jobExperienceResumeItem = jobExperienceItem
    }

    @Test
    fun `binds transformation`() {
        tested.bindViewHolder(jobExperienceItem)

        verify(jobBindingMock).transformation = transforamtionMock
    }

}