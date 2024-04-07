package com.example.domain

import com.example.data.entity.Company

class GetData(private val repo: ExerciseFirstRepository) {
    fun getData(): List<Company> {
        return repo.getData()
    }
}