package com.nihilus13.ui.common.holders

import com.nihilus13.resume.databinding.RecyclerSectionBinding
import com.nihilus13.uimodels.ResumeItem
import com.nihilus13.uimodels.SectionResumeItem

open class SectionViewHolder(private val binding: RecyclerSectionBinding) :
    AbstractViewHolder(binding.root) {

    override fun bindViewHolder(item: ResumeItem) =
        with(binding) {
            item as SectionResumeItem
            binding.sectionResumeItem = item
        }
}