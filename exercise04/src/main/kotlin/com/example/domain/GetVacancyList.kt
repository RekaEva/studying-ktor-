package com.example.domain

import com.example.domain.entity.Company
import com.example.domain.entity.Vacancy

class GetVacancyList(private val repo: ExerciseRepository) {
    fun getVacancyList(list: List<Company>): List<Vacancy> {
        return repo.getListVacancy(list)
    }
}