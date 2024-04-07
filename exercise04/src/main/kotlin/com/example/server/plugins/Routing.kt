package com.example.server.plugins

import com.example.data.ExerciseRepositoryImpl
import com.example.domain.GetCompanyById
import com.example.domain.GetListCompanies
import com.example.domain.GetVacancyById
import com.example.domain.GetVacancyList
import com.example.domain.entity.Company
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val companies = GetListCompanies(ExerciseRepositoryImpl()).getData()
    routing {
        companies(companies)
        companyById()
        vacancies(companies)
        vacancyById(companies)
    }
}
fun Route.vacancies(companyList: List<Company>) {
    val vacancyList = GetVacancyList(ExerciseRepositoryImpl()).getVacancyList(companyList)
    get("/vacancies") {
        call.respond(vacancyList)
    }

}
fun Route.vacancyById(list: List<Company>) {
    get("/vacancies/{id}") {
        val id = call.parameters["id"]?.toIntOrNull()
        if (id != null) {
            val vacancy = GetVacancyById(ExerciseRepositoryImpl()).getCVacancyById(list, id)
            if (vacancy != null) {
                call.respond(vacancy)
            } else {
                call.respond("")
            }
        } else {
            call.respond(HttpStatusCode.BadRequest, "Invalid ID format")
        }
    }
}
fun Route.companies(companyList: List<Company>) {
    get("/companies") {
        call.respond(companyList)
    }
}
fun Route.companyById() {
    get("/companies/{id}") {
        val id = call.parameters["id"]?.toIntOrNull()
        if (id != null) {
            val company = GetCompanyById(ExerciseRepositoryImpl())
                .getCompanyById(id)
            if (company != null) {
                call.respond(company)
            } else {
                call.respond("")
            }
        } else {
            call.respond(HttpStatusCode.BadRequest, "Invalid ID format")
        }
    }
}
