package com.nihilus13.transformer

import com.nihilus13.domain.model.*
import com.nihilus13.resume.R
import com.nihilus13.uimodels.*

class ResumeTransformer : DataToResumeItemTransformer<Resume> {

    override fun prepareResumeItemList(dataItem: Resume?): List<ResumeItem> =
        mutableListOf<ResumeItem>().apply {
            if (dataItem != null) {
                add(preparePerson(dataItem.person))
                add(SectionResumeItem(R.string.section_contact))
                add(prepareContact(dataItem.contact))
                /** in tests takeIf statement cannot be evaluated
                 *dataItem.listEducation.takeIf { isNotEmpty() }?.let {
                add(SectionResumeItem(R.string.section_education))
                addAll(prepareListEducation(it))
                }
                }*/
                if (dataItem.listEducation.isNotEmpty()) {
                    add(SectionResumeItem(R.string.section_education))
                    addAll(prepareListEducation(dataItem.listEducation))
                }
                if (dataItem.listJobExperience.isNotEmpty()) {
                    add(SectionResumeItem(R.string.section_job))
                    addAll(prepareListJobExperience(dataItem.listJobExperience))
                }
                if (dataItem.listSkill.isNotEmpty()) {
                    add(SectionResumeItem(R.string.section_skills))
                    addAll(prepareListSkill(dataItem.listSkill))
                }
            }
        }

    private fun preparePerson(person: Person): PersonResumeItem = PersonResumeItem(person)
    private fun prepareContact(contact: Contact): ContactResumeItem = ContactResumeItem(contact)
    private fun prepareListEducation(list: List<Education>): List<EducationResumeItem> =
        list.map { EducationResumeItem(it) }

    private fun prepareListJobExperience(list: List<JobExperience>): List<JobExperienceResumeItem> =
        list.map { JobExperienceResumeItem(it) }

    private fun prepareListSkill(list: List<Skill>): List<SkillResumeItem> =
        list.map { SkillResumeItem(it) }

}