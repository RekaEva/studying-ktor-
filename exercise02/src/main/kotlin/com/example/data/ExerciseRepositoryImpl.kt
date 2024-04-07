package com.example.data

import com.example.data.entity.Companies
import com.example.data.entity.Company
import com.example.domain.ExerciseRepository
import kotlinx.serialization.json.Json
import java.io.File

class ExerciseRepositoryImpl() : ExerciseRepository {

    private val readJson = File("src/main/kotlin/com/example/data/listOfCompanies.json").readText()
    private val companies = Json.decodeFromString<Companies>(readJson).listOfCompanies

    override fun getListCompanies(): List<Company> {
        val updatedCompanies = companies.mapIndexed { index, company ->
            company.copy(id = index + 1)
        }
        return updatedCompanies
    }

    override fun getCompanyById(id: Int): Company? {
        return getListCompanies().find { it.id == id }
    }

}