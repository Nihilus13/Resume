package com.nihilus13.ui.resume.adapter.holders

import com.nihilus13.resume.databinding.RecyclerContactBinding
import com.nihilus13.ui.common.holders.AbstractViewHolder
import com.nihilus13.ui.resume.adapter.onclick.OnDataBindViewClick
import com.nihilus13.uimodels.ContactResumeItem

class ContactViewHolder(
    private val onPhoneClick: OnDataBindViewClick,
    private val onMailClick: OnDataBindViewClick,
    private val onLinkedInClick: OnDataBindViewClick,
    private val binding: RecyclerContactBinding
) :
    AbstractViewHolder<ContactResumeItem>(binding.root) {
    override fun bindViewHolder(item: ContactResumeItem) =
        with(binding) {
            contactResumeItem = item
            onPhoneClicklistener = onPhoneClick
            onMailClicklistener = onMailClick
            onLinkedInClicklistener = onLinkedInClick
        }
}
