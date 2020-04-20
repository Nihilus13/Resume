package com.nihilus13.ui.resume.state

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.nihilus13.data.BR
import com.nihilus13.uimodels.ResumeItem

class ViewState : BaseObservable() {

    @Bindable
    var listResume: List<ResumeItem> = emptyList()
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.listResume)
            }
        }

    @Bindable
    var loading: Boolean = true
        set(value) {
            if (field != value) {
                field = value

                notifyPropertyChanged(BR.loading)
            }
        }

    @Bindable
    var hasError: Boolean = false
        set(value) {
            if (field != value) {
                field = value

                notifyPropertyChanged(BR.hasError)
            }
        }

    fun applyChanges(viewState: ViewState) {
        listResume = viewState.listResume
        loading = viewState.loading
        hasError = viewState.hasError
    }
}