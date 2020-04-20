package com.nihilus13.data.repository.datasource.cached

import com.nihilus13.data.repository.datasource.CachedResumeDataSource

object CachedResumeDataSourceProvider {
    private lateinit var cachedResumeDataSource: CachedResumeDataSource

    fun getCachedDataSource(): CachedResumeDataSource {
        if (!CachedResumeDataSourceProvider::cachedResumeDataSource.isInitialized) {
            cachedResumeDataSource = CachedResumeDataSourceImpl()
        }
        return cachedResumeDataSource
    }
}