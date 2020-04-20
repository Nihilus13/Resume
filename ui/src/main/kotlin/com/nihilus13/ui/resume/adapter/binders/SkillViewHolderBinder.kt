package com.nihilus13.ui.resume.adapter.binders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nihilus13.resume.R
import com.nihilus13.resume.databinding.RecyclerSkillBinding
import com.nihilus13.ui.common.binders.ViewHolderBinder
import com.nihilus13.ui.resume.adapter.holders.SkillViewHolder

class SkillViewHolderBinder internal constructor(bindingInflater: (ViewGroup) -> RecyclerSkillBinding) :
    ViewHolderBinder<SkillViewHolder, RecyclerSkillBinding>(bindingInflater) {

    constructor() : this({
        RecyclerSkillBinding.inflate(
            LayoutInflater.from(it.context),
            it,
            false
        )
    })

    override fun getViewHolderType(): Int = R.layout.recycler_skill

    override fun createViewHolder(parent: ViewGroup): SkillViewHolder =
        SkillViewHolder(createBinding(parent))

}