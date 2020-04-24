package com.nihilus13.ui.resume.adapter.holders

import com.nihilus13.imageloader.TransformationType
import com.nihilus13.resume.R
import com.nihilus13.resume.databinding.RecyclerEducationBinding
import com.nihilus13.ui.common.holders.AbstractViewHolder
import com.nihilus13.uimodels.EducationResumeItem

class EducationViewHolder(
    private val binding: RecyclerEducationBinding,
    private val transformationType: TransformationType = TransformationType.RoundedCorners(
        binding.root.context.resources.getDimension(
            R.dimen.margin_small
        )
    )
) :
    AbstractViewHolder<EducationResumeItem>(binding.root) {

    override fun bindViewHolder(item: EducationResumeItem) =
        with(binding) {
            educationResumeItem = item
            transformation = transformationType
        }
}