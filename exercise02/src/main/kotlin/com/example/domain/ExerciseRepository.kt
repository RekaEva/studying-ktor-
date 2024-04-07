package com.example.domain

import com.example.data.entity.Company

interface ExerciseRepository {
    fun getListCompanies(): List<Company>
    fun getCompanyById(id: Int): Company?
}