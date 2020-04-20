package com.nihilus13.data.repository.repository

object ResumeRepositoryProvider {

    private lateinit var resumeRepository: ResumeRepositoryImpl

    fun getRestaurantRepository(): ResumeRepositoryImpl {
        if (!ResumeRepositoryProvider::resumeRepository.isInitialized) {
            resumeRepository =
                ResumeRepositoryImpl()
        }
        return resumeRepository
    }
}