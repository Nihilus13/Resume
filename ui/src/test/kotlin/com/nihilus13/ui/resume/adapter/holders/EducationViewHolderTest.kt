package com.nihilus13.ui.resume.adapter.holders

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.domain.model.Education
import com.nihilus13.domain.model.Period
import com.nihilus13.imageloader.TransformationType
import com.nihilus13.resume.databinding.RecyclerEducationBinding
import com.nihilus13.uimodels.EducationResumeItem
import org.junit.Test
import java.util.*

class EducationViewHolderTest {

    private val educationBindingMock = mock<RecyclerEducationBinding> {
        on { root } doReturn (mock())
    }

    private val educationItem = EducationResumeItem(
        Education(Period(Date(), Date()), "", "", "", "")
    )
    private val transforamtionMock: TransformationType = mock()

    private val tested = EducationViewHolder(educationBindingMock, transforamtionMock)

    @Test
    fun `binds education`() {
        tested.bindViewHolder(educationItem)

        verify(educationBindingMock).educationResumeItem = educationItem
    }

    @Test
    fun `binds transformation`() {
        tested.bindViewHolder(educationItem)

        verify(educationBindingMock).transformation = transforamtionMock
    }
}