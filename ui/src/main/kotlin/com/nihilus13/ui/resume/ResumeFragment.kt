package com.nihilus13.ui.resume

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nihilus13.helper.startActivitySafely
import com.nihilus13.resume.R
import com.nihilus13.resume.databinding.FragmentResumeBinding
import com.nihilus13.ui.common.binders.SectionViewHolderBinder
import com.nihilus13.ui.common.binders.ViewHolderBinder
import com.nihilus13.ui.common.holders.AbstractViewHolder
import com.nihilus13.ui.resume.adapter.ResumeAdapter
import com.nihilus13.ui.resume.adapter.binders.*
import com.nihilus13.ui.resume.adapter.onclick.OnDataBindViewClick
import com.nihilus13.ui.resume.adapter.onclick.OnEmptyBindViewClick
import com.nihilus13.uimodels.ResumeItem

class ResumeFragment : Fragment() {

    private lateinit var binding: FragmentResumeBinding
    private lateinit var resumeAdapter: ResumeAdapter

    private val viewModel: ResumeViewModel by viewModels { ResumeViewModelFactory() }

    private val onPhoneClick: OnDataBindViewClick = object : OnDataBindViewClick {
        override fun onClick(contact: String) = callPhone(contact)
    }
    private val onMailClick: OnDataBindViewClick = object : OnDataBindViewClick {
        override fun onClick(contact: String) = sendMail(contact)
    }
    private val onLinkedInClick: OnDataBindViewClick = object : OnDataBindViewClick {
        override fun onClick(contact: String) = openBrowser(contact)
    }
    private val onErrorClick: OnEmptyBindViewClick = object : OnEmptyBindViewClick {
        override fun onClick() = fetchResume()
    }

    private val viewHolderBinders =
        setOf(
            PersonViewHolderBinder(),
            ContactViewHolderBinder(onPhoneClick, onMailClick, onLinkedInClick),
            SectionViewHolderBinder(),
            EducationViewHolderBinder(),
            JobExperienceViewHolderBinder(),
            SkillViewHolderBinder()
        )

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResumeBinding.inflate(inflater, container, false)
        resumeAdapter =
            ResumeAdapter(viewHolderBinders as Set<ViewHolderBinder<out AbstractViewHolder<ResumeItem>, ResumeItem, out ViewDataBinding>>)

        with(binding) {
            layoutError.onErrorClickListener = onErrorClick
            recyclerResume.apply {
                adapter = resumeAdapter
                layoutManager =
                    LinearLayoutManager(activity).apply { orientation = RecyclerView.VERTICAL }
                setHasFixedSize(true)
            }
            swipeRecyclerHome.setOnRefreshListener {
                fetchResume()
            }
            viewState = viewModel.viewState
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.start()
        fetchResume()
    }

    override fun onStop() {
        super.onStop()
        viewModel.stop()
    }

    private fun fetchResume() {
        binding.swipeRecyclerHome.isRefreshing = true
        viewModel.fetchResume()
    }

    private fun callPhone(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
        startActivitySafely(intent)
    }

    private fun sendMail(mail: String) {
        val emailIntent =
            Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$mail"))
                .apply {
                    putExtra(Intent.EXTRA_SUBJECT, getString(R.string.contact_mail_subject))
                }

        startActivitySafely(
            Intent.createChooser(
                emailIntent,
                getString(R.string.contact_mail_title)
            )
        )
    }

    private fun openBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivitySafely(intent)
    }
}
