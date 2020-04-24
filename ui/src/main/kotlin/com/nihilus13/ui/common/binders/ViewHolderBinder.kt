package com.nihilus13.ui.common.binders

import android.view.ViewGroup
import com.nihilus13.ui.common.holders.AbstractViewHolder
import com.nihilus13.uimodels.ResumeItem

abstract class ViewHolderBinder<T : AbstractViewHolder<RI>, in RI : ResumeItem, B>
internal constructor(private val inflateBinding: (ViewGroup) -> B) {
    abstract fun getViewHolderType(): Int
    abstract fun createViewHolder(parent: ViewGroup): T
    abstract fun typeCheck(resumeItem: ResumeItem): Boolean

    fun createBinding(parent: ViewGroup): B = inflateBinding(parent)
    fun isInstanceOfBinder(
        item: ResumeItem,
        func: (ResumeItem) -> Boolean = { typeCheck(it) }
    ): Boolean = func(item)
}