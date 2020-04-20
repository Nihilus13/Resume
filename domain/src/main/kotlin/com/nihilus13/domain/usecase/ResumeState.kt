package com.nihilus13.domain.usecase

import com.nihilus13.domain.model.Resume

sealed class ResumeState {
    data class ResumeData(val resume: Resume?) : ResumeState()

    object Error : ResumeState()

    object Loading : ResumeState()
}