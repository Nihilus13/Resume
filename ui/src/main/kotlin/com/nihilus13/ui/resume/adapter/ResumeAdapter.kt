package com.nihilus13.ui.resume.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nihilus13.resume.R
import com.nihilus13.ui.common.binders.ViewHolderBinder
import com.nihilus13.ui.common.holders.AbstractViewHolder
import com.nihilus13.uimodels.*

class ResumeAdapter(private val setViewHolderBinders: Set<ViewHolderBinder<out AbstractViewHolder, *>>) :
    RecyclerView.Adapter<AbstractViewHolder>() {

    var listCombined: MutableList<ResumeItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder =
        setViewHolderBinders
            .first {
                it.getViewHolderType() == viewType
            }
            .createViewHolder(parent)

    override fun getItemCount(): Int = listCombined.size

    override fun getItemViewType(position: Int): Int =
        when (listCombined[position]) {
            is SectionResumeItem -> R.layout.recycler_section
            is PersonResumeItem -> R.layout.recycler_person
            is ContactResumeItem -> R.layout.recycler_contact
            is JobExperienceResumeItem -> R.layout.recycler_job_experience
            is EducationResumeItem -> R.layout.recycler_education
            else -> R.layout.recycler_skill
        }

    override fun onBindViewHolder(holder: AbstractViewHolder, position: Int) =
        holder.bindViewHolder(listCombined[position])

    fun setResumeList(list: List<ResumeItem>) =
        listCombined.apply {
            /**of course in more refined use case, it should be here some [DiffUtil.Callback]*/
            clear()
            addAll(list)
            notifyDataSetChanged()
        }
}