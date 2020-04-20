package com.nihilus13.uimodels

import androidx.annotation.StringRes
import com.nihilus13.dateutils.SimpleDateFormatter.formatMonthYear
import com.nihilus13.dateutils.SimpleDateFormatter.formatYear
import com.nihilus13.domain.model.*

data class SectionResumeItem(@StringRes var titleResId: Int) : ResumeItem

data class PersonResumeItem(val person: Person) : ResumeItem

data class ContactResumeItem(val contact: Contact) : ResumeItem

data class JobExperienceResumeItem(val jobExperience: JobExperience) : ResumeItem,
    PeriodFormatableLong {
    override fun getPeriod(): Period = jobExperience.period

    //need to be override to be visible in databinding
    override fun formatPeriod(): String = super.formatPeriod()
}

data class SkillResumeItem(val skill: Skill) : ResumeItem

data class EducationResumeItem(val education: Education) : ResumeItem, PeriodFormatableShort {
    override fun getPeriod(): Period = education.period

    //need to be override to be visible in databinding
    override fun formatPeriod(): String = super.formatPeriod()
}

interface PeriodFormatableLong {
    fun getPeriod(): Period
    fun formatPeriod(): String =
        "${formatMonthYear(getPeriod().dateStart)}${getPeriod().dateEnd?.let {
            " - ${formatMonthYear(it)}"
        } ?: ""}"
}

interface PeriodFormatableShort {
    fun getPeriod(): Period
    fun formatPeriod(): String =
        "${formatYear(getPeriod().dateStart)}${getPeriod().dateEnd?.let { " - ${formatYear(it)}" } ?: ""}"
}