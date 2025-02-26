package ktor

import domain.country.models.country.Country
import domain.country.models.country.UpdateCountry
import domain.country.models.enums.Language
import domain.country.usecase.ProviderUseCase
import domain.country.usecase.ProviderUseCase.logger
import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ktor.routing.countryRouting

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        countryRouting()
        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}