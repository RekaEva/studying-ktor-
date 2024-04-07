package com.example.data

import com.example.data.entity.Companies
import com.example.data.entity.Company
import com.example.domain.ExerciseFirstRepository
import kotlinx.serialization.json.Json
import java.io.File

class ExerciseFirstRepositoryImpl() : ExerciseFirstRepository {
    override fun getData(): List<Company> {
        val readJson = File("src/main/kotlin/com/example/data/listOfCompanies.json").readText()
        val companies = Json.decodeFromString<Companies>(readJson).listOfCompanies
        val updatedCompanies = companies.mapIndexed { index, company ->
            company.copy(id = index + 1)
        }
        return updatedCompanies
    }
}