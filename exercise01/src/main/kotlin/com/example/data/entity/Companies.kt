package com.example.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class Companies(
    val listOfCompanies: List<Company>
)