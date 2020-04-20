package com.nihilus13.ui.resume.adapter.binders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nihilus13.resume.R
import com.nihilus13.resume.databinding.RecyclerJobExperienceBinding
import com.nihilus13.ui.common.binders.ViewHolderBinder
import com.nihilus13.ui.resume.adapter.holders.JobExperienceViewHolder

class JobExperienceViewHolderBinder internal constructor(bindingInflater: (ViewGroup) -> RecyclerJobExperienceBinding) :
    ViewHolderBinder<JobExperienceViewHolder, RecyclerJobExperienceBinding>(bindingInflater) {

    constructor() : this({
        RecyclerJobExperienceBinding.inflate(
            LayoutInflater.from(it.context),
            it,
            false
        )
    })

    override fun getViewHolderType(): Int = R.layout.recycler_job_experience

    override fun createViewHolder(parent: ViewGroup): JobExperienceViewHolder =
        JobExperienceViewHolder(createBinding(parent))

}