package com.nihilus13.ui.resume.adapter.binders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nihilus13.resume.R
import com.nihilus13.resume.databinding.RecyclerEducationBinding
import com.nihilus13.ui.common.binders.ViewHolderBinder
import com.nihilus13.ui.resume.adapter.holders.EducationViewHolder
import com.nihilus13.uimodels.EducationResumeItem
import com.nihilus13.uimodels.ResumeItem

class EducationViewHolderBinder internal constructor(bindingInflater: (ViewGroup) -> RecyclerEducationBinding) :
    ViewHolderBinder<EducationViewHolder, EducationResumeItem, RecyclerEducationBinding>(
        bindingInflater
    ) {

    constructor() : this({
        RecyclerEducationBinding.inflate(
            LayoutInflater.from(it.context),
            it,
            false
        )
    })

    override fun getViewHolderType(): Int = R.layout.recycler_education

    override fun createViewHolder(parent: ViewGroup): EducationViewHolder =
        EducationViewHolder(createBinding(parent))

    override fun typeCheck(resumeItem: ResumeItem): Boolean = resumeItem is EducationResumeItem

}