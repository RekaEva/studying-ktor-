package com.example.domain.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Company(
    val name: String?,
    val id: Int = 0,
    @SerialName("field_of_activity") val fieldOfActivity: String?,
    val vacancies: List<Vacancy>,
    val contacts: String?
)
