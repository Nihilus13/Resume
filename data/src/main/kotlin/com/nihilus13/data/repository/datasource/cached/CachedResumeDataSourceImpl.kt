package com.nihilus13.data.repository.datasource.cached

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nihilus13.data.repository.datasource.CachedResumeDataSource
import com.nihilus13.domain.model.Resume

class CachedResumeDataSourceImpl : CachedResumeDataSource {

    private val resumeObservable = MutableLiveData<Resume>()

    override fun getResumeObservable(): LiveData<Resume> = resumeObservable

    override fun refresh(resume: Resume?) = resumeObservable.postValue(resume)

}