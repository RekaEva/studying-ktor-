package com.example.domain

import com.example.domain.entity.Company
import com.example.domain.entity.Vacancy

interface ExerciseRepository {
    fun getListCompanies(): List<Company>
    fun getCompanyById(id: Int): Company?
    fun getListVacancy(list: List<Company>): List<Vacancy>
}