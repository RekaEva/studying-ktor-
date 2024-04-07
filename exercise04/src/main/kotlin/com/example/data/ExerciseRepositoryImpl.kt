package com.example.data

import com.example.domain.ExerciseRepository
import com.example.domain.entity.Companies
import com.example.domain.entity.Company
import com.example.domain.entity.Vacancy
import kotlinx.serialization.json.Json
import java.io.File

class ExerciseRepositoryImpl : ExerciseRepository {
    override fun getListCompanies(): List<Company> {
        val readJson = File("src/main/kotlin/com/example/data/listOfCompanies.json").readText()
        val companies = Json.decodeFromString<Companies>(readJson).listOfCompanies
        val updatedCompanies = companies.mapIndexed { index, company ->
            company.copy(id = index + 1)
        }
        return updatedCompanies
    }

    override fun getCompanyById(id: Int): Company? {
        return getListCompanies().find { it.id == id }
    }

    override fun getListVacancy(list: List<Company>): List<Vacancy> {
        val listOfVacancy = list.flatMap { company ->
            company.vacancies.map { vacancy ->
                Vacancy(
                    profession = vacancy.profession,
                    level = vacancy.level,
                    salary = vacancy.salary,
                    companyName = company.name,
                )
            }
        }
        val addIdToVacancy = listOfVacancy.mapIndexed { index, vacancy ->
            vacancy.copy(id = index + 1)
        }
        return addIdToVacancy
    }

    override fun getVacancyById(list: List<Company>, id: Int): Vacancy? {
        return getListVacancy(list).find { it.id == id }
    }
}