package com.nihilus13.ui.resume.adapter.holders

import com.nihilus13.imageloader.TransformationType
import com.nihilus13.resume.R
import com.nihilus13.resume.databinding.RecyclerPersonBinding
import com.nihilus13.ui.common.holders.AbstractViewHolder
import com.nihilus13.uimodels.PersonResumeItem
import com.nihilus13.uimodels.ResumeItem

class PersonViewHolder(
    private val binding: RecyclerPersonBinding,
    private val transformationType: TransformationType = TransformationType.RoundedCorners(
        binding.root.context.resources.getDimension(
            R.dimen.margin_small
        )
    )
) :
    AbstractViewHolder(binding.root) {

    override fun bindViewHolder(item: ResumeItem) =
        with(binding) {
            item as PersonResumeItem
            personResumeItem = item
            transformation = transformationType
        }
}