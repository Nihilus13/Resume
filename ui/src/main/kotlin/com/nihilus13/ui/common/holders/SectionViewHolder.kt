package com.nihilus13.ui.common.holders

import com.nihilus13.resume.databinding.RecyclerSectionBinding
import com.nihilus13.uimodels.SectionResumeItem

open class SectionViewHolder(private val binding: RecyclerSectionBinding) :
    AbstractViewHolder<SectionResumeItem>(binding.root) {

    override fun bindViewHolder(item: SectionResumeItem) =
        with(binding) {
            binding.sectionResumeItem = item
        }
}