package com.nihilus13.data.repository.usecase

import com.nihilus13.coroutines.safeapi.SafeApiResponse
import com.nihilus13.coroutines.safeapi.safeApiCall
import com.nihilus13.domain.model.Resume
import com.nihilus13.domain.repository.ResumeRepository
import com.nihilus13.domain.usecase.FetchResumeHandler

internal class FetchResumeHandlerImpl internal constructor(private val resumeRepository: ResumeRepository) :
    FetchResumeHandler {

    override suspend fun handleResumeResponse() =
        handleResponse(safeApiCall { resumeRepository.fetchResume() })


    private fun handleResponse(result: SafeApiResponse<Resume>) {
        with(resumeRepository) {
            when (result) {
                is SafeApiResponse.Success -> refreshResume(result.getData())
                is SafeApiResponse.Failure -> refreshResume(null)
            }
        }
    }
}