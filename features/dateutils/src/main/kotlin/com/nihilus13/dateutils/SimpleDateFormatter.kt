package com.nihilus13.dateutils

import java.text.SimpleDateFormat
import java.util.*

object SimpleDateFormatter {

    private val monthYearDateFormat = SimpleDateFormat(DateConstants.MONTH_YEAR_PATTERN, Locale.UK)
    private val yearDateFormat = SimpleDateFormat(DateConstants.YEAR_PATTERN, Locale.UK)

    fun formatMonthYear(date: Date): String = monthYearDateFormat.format(date)

    fun formatYear(date: Date): String = yearDateFormat.format(date)

}