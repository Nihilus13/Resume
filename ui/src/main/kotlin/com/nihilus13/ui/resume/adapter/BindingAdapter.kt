package com.nihilus13.ui.resume.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nihilus13.imageloader.ImageLoadManagerProvider.getImageLoaderManager
import com.nihilus13.imageloader.TransformationType
import com.nihilus13.uimodels.ResumeItem

@BindingAdapter("setResume")
fun RecyclerView.setResume(listResume: List<ResumeItem>) =
    (adapter as ResumeAdapter).setResumeList(listResume)


@BindingAdapter("image", "transformation", requireAll = false)
fun ImageView.loadImage(image: String, transformationType: TransformationType? = null) {
    getImageLoaderManager().loadImage(this, image, transformationType)
}