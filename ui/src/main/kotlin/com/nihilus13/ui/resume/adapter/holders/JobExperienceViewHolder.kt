package com.nihilus13.ui.resume.adapter.holders

import com.nihilus13.imageloader.TransformationType
import com.nihilus13.resume.R
import com.nihilus13.resume.databinding.RecyclerJobExperienceBinding
import com.nihilus13.ui.common.holders.AbstractViewHolder
import com.nihilus13.uimodels.JobExperienceResumeItem
import com.nihilus13.uimodels.ResumeItem

class JobExperienceViewHolder(
    private val binding: RecyclerJobExperienceBinding,
    private val transformationType: TransformationType = TransformationType.RoundedCorners(
        binding.root.context.resources.getDimension(
            R.dimen.margin_small
        )
    )
) :
    AbstractViewHolder(binding.root) {

    override fun bindViewHolder(item: ResumeItem) =
        with(binding) {
            item as JobExperienceResumeItem
            jobExperienceResumeItem = item
            transformation = transformationType
        }
}