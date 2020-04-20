package com.nihilus13.ui.common.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nihilus13.uimodels.ResumeItem

abstract class AbstractViewHolder(binding: View) : RecyclerView.ViewHolder(binding) {
    abstract fun bindViewHolder(item: ResumeItem)
}
