package com.nihilus13.data.repository.repository

import androidx.lifecycle.LiveData
import com.nihilus13.data.repository.datasource.CachedResumeDataSource
import com.nihilus13.data.repository.datasource.RemoteResumeDataSource
import com.nihilus13.data.repository.datasource.cached.CachedResumeDataSourceProvider.getCachedDataSource
import com.nihilus13.data.repository.datasource.remote.RemoteResumeDataSourceProvider.getRemoteDataSource
import com.nihilus13.domain.model.Resume
import com.nihilus13.domain.repository.ResumeRepository

class ResumeRepositoryImpl internal constructor(
    private val remoteResumeDataSource: RemoteResumeDataSource,
    private val cachedResumeDataSource: CachedResumeDataSource
) : ResumeRepository {
    constructor() : this(getRemoteDataSource(), getCachedDataSource())

    override suspend fun fetchResume() = remoteResumeDataSource.fetchResume()

    override fun refreshResume(resume: Resume?) = cachedResumeDataSource.refresh(resume)

    override fun getResumeObservable(): LiveData<Resume> =
        cachedResumeDataSource.getResumeObservable()

}