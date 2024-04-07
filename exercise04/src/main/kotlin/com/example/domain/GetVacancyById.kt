package com.example.domain

import com.example.domain.entity.Company
import com.example.domain.entity.Vacancy

class GetVacancyById(private val repo: ExerciseRepository) {
    fun getCVacancyById(list: List<Company>, id: Int): Vacancy? {
        return repo.getVacancyById(list, id)
    }
}