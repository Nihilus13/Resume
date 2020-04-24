package com.nihilus13.ui.resume.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nihilus13.ui.common.binders.ViewHolderBinder
import com.nihilus13.ui.common.holders.AbstractViewHolder
import com.nihilus13.uimodels.ResumeItem

class ResumeAdapter(private val setViewHolderBinders: Set<ViewHolderBinder<out AbstractViewHolder<ResumeItem>, ResumeItem, out ViewDataBinding>>) :
    RecyclerView.Adapter<AbstractViewHolder<ResumeItem>>() {

    var listCombined: MutableList<ResumeItem> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbstractViewHolder<ResumeItem> =
        setViewHolderBinders
            .first {
                it.getViewHolderType() == viewType
            }
            .createViewHolder(parent)

    override fun getItemCount(): Int = listCombined.size

    override fun getItemViewType(position: Int) =
        setViewHolderBinders
            .first { it.isInstanceOfBinder(listCombined[position]) }
            .getViewHolderType()

    override fun onBindViewHolder(holder: AbstractViewHolder<ResumeItem>, position: Int) =
        holder.bindViewHolder(listCombined[position])

    fun setResumeList(list: List<ResumeItem>) =
        listCombined.apply {
            /**of course in more refined use case, it should be here some [DiffUtil.Callback]*/
            clear()
            addAll(list)
            notifyDataSetChanged()
        }

}