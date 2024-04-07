package com.example.server.plugins

import com.example.data.ExerciseRepositoryImpl
import com.example.domain.GetCompanyById
import com.example.domain.GetListCompanies
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        companies()
        companyById()
    }
}
fun Route.companies() {
    val companies = GetListCompanies(ExerciseRepositoryImpl()).getData()
    get("/companies") {
        call.respond(companies)
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
