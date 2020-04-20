package com.nihilus13.data.repository.datasource

import androidx.lifecycle.LiveData
import com.nihilus13.domain.model.Resume

interface RemoteResumeDataSource {
    suspend fun fetchResume(): Resume
}

interface CachedResumeDataSource {
    fun getResumeObservable(): LiveData<Resume>
    fun refresh(resume: Resume?)
}