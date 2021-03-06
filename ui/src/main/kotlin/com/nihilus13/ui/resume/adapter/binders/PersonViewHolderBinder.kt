package com.nihilus13.ui.resume.adapter.binders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nihilus13.resume.R
import com.nihilus13.resume.databinding.RecyclerPersonBinding
import com.nihilus13.ui.common.binders.ViewHolderBinder
import com.nihilus13.ui.resume.adapter.holders.PersonViewHolder
import com.nihilus13.uimodels.PersonResumeItem
import com.nihilus13.uimodels.ResumeItem

class PersonViewHolderBinder internal constructor(bindingInflater: (ViewGroup) -> RecyclerPersonBinding) :
    ViewHolderBinder<PersonViewHolder, PersonResumeItem, RecyclerPersonBinding>(bindingInflater) {

    constructor() : this({
        RecyclerPersonBinding.inflate(
            LayoutInflater.from(it.context),
            it,
            false
        )
    })

    override fun getViewHolderType(): Int = R.layout.recycler_person

    override fun createViewHolder(parent: ViewGroup): PersonViewHolder =
        PersonViewHolder(createBinding(parent))

    override fun typeCheck(resumeItem: ResumeItem): Boolean = resumeItem is PersonResumeItem
}