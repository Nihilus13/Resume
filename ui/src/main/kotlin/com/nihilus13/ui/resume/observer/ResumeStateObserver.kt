package com.nihilus13.ui.resume.observer

import androidx.lifecycle.Observer
import com.nihilus13.domain.usecase.ResumeState
import com.nihilus13.ui.resume.state.ViewState

interface ResumeStateObserver : Observer<ResumeState> {
    val viewState: ViewState
}