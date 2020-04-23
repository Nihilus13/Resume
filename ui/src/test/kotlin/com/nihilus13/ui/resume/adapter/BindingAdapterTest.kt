package com.nihilus13.ui.resume.adapter

import android.content.Context
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nihilus13.domain.model.Skill
import com.nihilus13.imageloader.ImageLoadManagerProvider
import com.nihilus13.imageloader.TransformationType
import com.nihilus13.uimodels.ResumeItem
import com.nihilus13.uimodels.SkillResumeItem
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class BindingAdapterTest {

    private val context = ApplicationProvider.getApplicationContext<Context>()

    private val imageLoader = ImageLoadManagerProvider.getImageLoaderManager(mock())

    @Test
    fun `sets list of resume items to adapter`() = with(RecyclerView(context)) {
        adapter = ResumeAdapter(mock())
        val listResume = listOf<ResumeItem>(SkillResumeItem(Skill("", "")))

        setResume(listResume)

        assertEquals(
            "adapter should sets list of resume items, but it's not",
            listResume,
            (adapter as ResumeAdapter).listCombined
        )
    }

    @Test
    fun `adapter items size is correct`() = with(RecyclerView(context)) {
        adapter = ResumeAdapter(mock())
        val listResume = listOf<ResumeItem>(
            SkillResumeItem(Skill("", "")),
            SkillResumeItem(Skill("", ""))
        )

        setResume(listResume)

        assertEquals(
            "adapter should have the same size of list after set, but it's not",
            listResume.size, (adapter as ResumeAdapter).listCombined.size
        )
    }

    @Test
    fun `loads image with no transformation`() = with(ImageView(context)) {
        val url = ""

        loadImage(url)

        verify(imageLoader).loadImage(this, url)
    }

    @Test
    fun `loads image with transformation`() = with(ImageView(context)) {
        val url = ""
        val transformationType: TransformationType = mock()

        loadImage(url, transformationType)

        verify(imageLoader).loadImage(this, url, transformationType)
    }
}