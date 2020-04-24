package com.nihilus13.ui.common.binders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nihilus13.resume.R
import com.nihilus13.resume.databinding.RecyclerSectionBinding
import com.nihilus13.ui.common.holders.SectionViewHolder
import com.nihilus13.uimodels.ResumeItem
import com.nihilus13.uimodels.SectionResumeItem

class SectionViewHolderBinder internal constructor(bindingInflater: (ViewGroup) -> RecyclerSectionBinding) :
    ViewHolderBinder<SectionViewHolder, SectionResumeItem, RecyclerSectionBinding>(bindingInflater) {
    constructor() : this({
        RecyclerSectionBinding.inflate(LayoutInflater.from(it.context), it, false)
    })

    override fun getViewHolderType(): Int = R.layout.recycler_section

    override fun createViewHolder(parent: ViewGroup): SectionViewHolder =
        SectionViewHolder(createBinding(parent))

    override fun typeCheck(resumeItem: ResumeItem): Boolean = resumeItem is SectionResumeItem
}