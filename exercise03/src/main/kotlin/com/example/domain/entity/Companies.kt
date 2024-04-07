package com.example.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Companies(
    val listOfCompanies: List<Company>
)