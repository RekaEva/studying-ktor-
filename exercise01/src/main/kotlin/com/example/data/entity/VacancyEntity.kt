package com.example.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class VacancyEntity(
    val profession: String,
    val level: String,
    val salary: Int,
    var companyName: String = "",
    var companyFieldOfActivity: String = ""
)