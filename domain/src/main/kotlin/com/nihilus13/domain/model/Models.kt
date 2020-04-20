package com.nihilus13.domain.model

import java.util.*

data class Person(val imageUrl: String, val fullName: String)

data class Contact(val number: String, val mail: String, val linkedInUrl: String)

data class Period(val dateStart: Date, val dateEnd: Date?)

data class Education(
    val period: Period,
    val educationPlaceLogo: String,
    val educationPlaceName: String,
    val major: String,
    val achievedLevel: String
)

data class Company(val name: String, val logoUrl: String, val url: String)

data class JobExperience(
    val period: Period,
    val company: Company,
    val jobPosition: String
)

data class Skill(val name: String, val iconUrl: String)

data class Resume(
    val person: Person,
    val contact: Contact,
    val listEducation: List<Education> = emptyList(),
    val listJobExperience: List<JobExperience> = emptyList(),
    val listSkill: List<Skill> = emptyList()
)