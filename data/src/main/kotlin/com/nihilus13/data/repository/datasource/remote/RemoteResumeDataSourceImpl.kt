package com.nihilus13.data.repository.datasource.remote

import com.nihilus13.data.repository.api.ApiProvider
import com.nihilus13.data.repository.api.ApiService
import com.nihilus13.data.repository.datasource.RemoteResumeDataSource

class RemoteResumeDataSourceImpl internal constructor(private val apiService: ApiService) :
    RemoteResumeDataSource {
    constructor() : this(ApiProvider.getService())

    override suspend fun fetchResume() = apiService.fetchResume()
}