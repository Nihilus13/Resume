package com.nihilus13.ui.resume.adapter.holders

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.domain.model.Skill
import com.nihilus13.imageloader.TransformationType
import com.nihilus13.resume.databinding.RecyclerSkillBinding
import com.nihilus13.uimodels.SkillResumeItem
import org.junit.Test

class SkillViewHolderTest {
    private val skillBindingMock = mock<RecyclerSkillBinding> {
        on { root } doReturn (mock())
    }

    private val skillItem = SkillResumeItem(
        Skill("", "")
    )
    private val transforamtionMock: TransformationType = mock()

    private val tested = SkillViewHolder(skillBindingMock, transforamtionMock)

    @Test
    fun `binds person`() {
        tested.bindViewHolder(skillItem)

        verify(skillBindingMock).skillResumeItem = skillItem
    }

    @Test
    fun `binds transformation`() {
        tested.bindViewHolder(skillItem)

        verify(skillBindingMock).transformation = transforamtionMock
    }
}