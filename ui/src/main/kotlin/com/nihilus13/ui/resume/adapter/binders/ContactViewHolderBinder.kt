package com.nihilus13.ui.resume.adapter.binders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nihilus13.resume.R
import com.nihilus13.resume.databinding.RecyclerContactBinding
import com.nihilus13.ui.common.binders.ViewHolderBinder
import com.nihilus13.ui.resume.adapter.holders.ContactViewHolder
import com.nihilus13.ui.resume.adapter.onclick.OnDataBindViewClick

class ContactViewHolderBinder internal constructor(
    private val onPhoneClick: OnDataBindViewClick,
    private val onMailClick: OnDataBindViewClick,
    private val onLinkedInClick: OnDataBindViewClick,
    bindingInflater: (ViewGroup) -> RecyclerContactBinding
) :
    ViewHolderBinder<ContactViewHolder, RecyclerContactBinding>(bindingInflater) {
    constructor(
        onPhoneClick: OnDataBindViewClick,
        onMailClick: OnDataBindViewClick,
        onLinkedInClick: OnDataBindViewClick
    ) : this(onPhoneClick, onMailClick, onLinkedInClick, {
        RecyclerContactBinding.inflate(
            LayoutInflater.from(it.context),
            it,
            false
        )
    })

    override fun getViewHolderType(): Int = R.layout.recycler_contact

    override fun createViewHolder(parent: ViewGroup): ContactViewHolder =
        ContactViewHolder(onPhoneClick, onMailClick, onLinkedInClick, createBinding(parent))
}