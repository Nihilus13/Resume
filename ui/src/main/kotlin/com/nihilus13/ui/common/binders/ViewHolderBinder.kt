package com.nihilus13.ui.common.binders

import android.view.ViewGroup
import com.nihilus13.ui.common.holders.AbstractViewHolder

abstract class ViewHolderBinder<T : AbstractViewHolder, B>
internal constructor(private val inflateBinding: (ViewGroup) -> B) {
    abstract fun getViewHolderType(): Int
    abstract fun createViewHolder(parent: ViewGroup): T
    fun createBinding(parent: ViewGroup): B = inflateBinding(parent)
    inline fun <reified T> isViewHolderBinder(viewHolder: AbstractViewHolder): Boolean =
        viewHolder is T
}