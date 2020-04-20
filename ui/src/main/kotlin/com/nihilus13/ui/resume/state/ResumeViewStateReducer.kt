package com.nihilus13.ui.resume.state

import com.nihilus13.domain.model.Resume
import com.nihilus13.domain.usecase.ResumeState
import com.nihilus13.transformer.DataToResumeItemTransformer
import com.nihilus13.transformer.ResumeTransformer
import com.nihilus13.ui.resume.state.reducer.ViewStateReducer

class ResumeViewStateReducer internal constructor(private val transformer: DataToResumeItemTransformer<Resume>) :
    ViewStateReducer<ViewState, ResumeState> {

    constructor() : this(ResumeTransformer())

    override fun reduce(viewState: ViewState, dataState: ResumeState): ViewState =
        when (dataState) {
            is ResumeState.ResumeData -> viewState.apply {
                listResume = transformer.prepareResumeItemList(dataState.resume)
                loading = false
                hasError = false
            }
            is ResumeState.Error -> viewState.apply {
                listResume = emptyList()
                loading = false
                hasError = true
            }
            else -> viewState.apply {
                loading = true
                hasError = false
            }
        }
}