package com.example.domain

import com.example.data.entity.Company

class GetListCompanies(private val repo: ExerciseRepository) {
    fun getData(): List<Company> {
        return repo.getListCompanies()
    }
}