package com.nihilus13.domain.repository

import androidx.lifecycle.LiveData
import com.nihilus13.domain.model.Resume

interface ResumeRepository {
    suspend fun fetchResume(): Resume
    fun refreshResume(resume: Resume?)
    fun getResumeObservable(): LiveData<Resume>
}