package com.example.server.plugins

import com.example.data.ExerciseFirstRepositoryImpl
import com.example.domain.GetData
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.configureRouting() {
    val company = GetData(ExerciseFirstRepositoryImpl()).getData()
    routing {
        get("/companies") {
            call.respond(company)
        }
    }
}
