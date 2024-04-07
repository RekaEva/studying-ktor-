package com.example.domain

import com.example.domain.entity.Company

class GetCompanyById(private val repo: ExerciseRepository) {
    fun getCompanyById(id: Int): Company? {
        return repo.getCompanyById(id)
    }
}