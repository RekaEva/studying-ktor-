package com.example.domain

import com.example.data.entity.Company

interface ExerciseFirstRepository {
    fun getData(): List<Company>
}