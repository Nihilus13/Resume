package com.nihilus13.ui.resume.state.reducer

interface ViewStateReducer<VS, DS> {
    fun reduce(viewState: VS, dataState: DS): VS
}