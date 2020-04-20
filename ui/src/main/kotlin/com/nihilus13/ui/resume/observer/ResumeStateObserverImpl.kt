package com.nihilus13.ui.resume.observer

import com.nihilus13.domain.usecase.ResumeState
import com.nihilus13.ui.resume.state.ViewState
import com.nihilus13.ui.resume.state.reducer.ViewStateReducer

class ResumeStateObserverImpl(private val stateReducer: ViewStateReducer<ViewState, ResumeState>) :
    ResumeStateObserver {

    override val viewState: ViewState = ViewState()

    override fun onChanged(t: ResumeState) {
        viewState.applyChanges(stateReducer.reduce(viewState, t))
    }

}