package com.nihilus13.helper

import android.os.Looper
import androidx.lifecycle.MutableLiveData

private fun isMainThread(): Boolean = Looper.myLooper() == Looper.getMainLooper()

fun <T> MutableLiveData<T>.postValueThreadSafety(value: T) =
    if (isMainThread()) this.setValue(value) else this.postValue(value)