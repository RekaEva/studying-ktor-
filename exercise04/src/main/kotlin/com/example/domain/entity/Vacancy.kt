package com.example.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Vacancy(
    val id: Int = 0,
    val profession: String,
    val level: String,
    val salary: Int,
    var companyName: String? = "",
    var companyFieldOfActivity: String = ""
)