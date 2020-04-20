package com.nihilus13.ui.resume

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ResumeViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ResumeViewModel() as T
}
