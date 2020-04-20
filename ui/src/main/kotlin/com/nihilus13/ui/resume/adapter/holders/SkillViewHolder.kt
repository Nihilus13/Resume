package com.nihilus13.ui.resume.adapter.holders

import com.nihilus13.imageloader.TransformationType
import com.nihilus13.resume.R
import com.nihilus13.resume.databinding.RecyclerSkillBinding
import com.nihilus13.ui.common.holders.AbstractViewHolder
import com.nihilus13.uimodels.ResumeItem
import com.nihilus13.uimodels.SkillResumeItem

class SkillViewHolder(
    private val binding: RecyclerSkillBinding,
    private val transformationType: TransformationType = TransformationType.RoundedCorners(
        binding.root.context.resources.getDimension(
            R.dimen.margin_small
        )
    )
) :
    AbstractViewHolder(binding.root) {

    override fun bindViewHolder(item: ResumeItem) =
        with(binding) {
            item as SkillResumeItem
            skillResumeItem = item
            transformation = transformationType
        }
}