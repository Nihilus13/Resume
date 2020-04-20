package com.nihilus13.transformer

import com.nihilus13.uimodels.ResumeItem

interface DataToResumeItemTransformer<T> {
    fun prepareResumeItemList(dataItem: T?): List<ResumeItem>
}