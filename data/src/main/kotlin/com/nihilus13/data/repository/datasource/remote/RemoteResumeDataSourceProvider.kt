package com.nihilus13.data.repository.datasource.remote

import com.nihilus13.data.repository.datasource.RemoteResumeDataSource

object RemoteResumeDataSourceProvider {
    private lateinit var remoteResumeDataSource: RemoteResumeDataSource

    fun getRemoteDataSource(): RemoteResumeDataSource {
        if (!RemoteResumeDataSourceProvider::remoteResumeDataSource.isInitialized) {
            remoteResumeDataSource =
                RemoteResumeDataSourceImpl()
        }
        return remoteResumeDataSource
    }
}