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

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        // Petición GET para obtener países
        get("/country") {
            val countryPid = call.request.queryParameters["pid"]
            logger.warn("El pid tiene valor de $countryPid")
            if (countryPid != null) {
                val country = ProviderUseCase.countryById(countryPid)
                if (country == null) {
                    call.respond(HttpStatusCode.NotFound, "País no encontrado")
                } else {
                    call.respond(country)
                }
                return@get
            }

            val language = call.request.queryParameters["language"]
            logger.warn("Language tiene valor de $language")
            if (language != null) {
                try {
                    val lang = language.uppercase()
                    logger.warn("Lenguaje seleccionado: ${Language.valueOf(lang)}")
                    val countries = ProviderUseCase.countryByLanguage(Language.valueOf(lang.uppercase()))
                    call.respond(countries)
                } catch (e: IllegalArgumentException) {
                    call.respond(HttpStatusCode.BadRequest, "Lenguaje no válido")
                }
            } else {
                val allCountries = ProviderUseCase.allCountries()
                call.respond(allCountries)
            }
        }

        // Petición POST para agregar un nuevo país
        post("/country") {
            try {
                val country = call.receive<Country>()
                val newCountry = ProviderUseCase.addCountry(country)
                if (!newCountry) {
                    call.respond(HttpStatusCode.Conflict, "El pais no ha podido insertarse, puede que ya exista")
                    return@post
                }
                call.respond(HttpStatusCode.Created, "Se ha insertado correctamente con pid = ${country.pid}")
            } catch (error: IllegalArgumentException) {
                call.respond(HttpStatusCode.BadRequest, error.localizedMessage)
            } catch (error: JsonConvertException) {
                call.respond(HttpStatusCode.BadRequest, error.localizedMessage)
            }
        }

        // Petición PATCH para editar un país
        patch("/country/{pid}") {
            try {
                val countryPid = call.parameters["pid"]
                countryPid?.let {
                    val updatedData = call.receive<UpdateCountry>()
                    val updatedCountry = ProviderUseCase.updateCountry(updatedData, countryPid)
                    if (!updatedCountry) {
                        call.respond(HttpStatusCode.Conflict, "El pais no puede modificarse, puede que ya exista")
                        return@patch
                    }
                    call.respond(HttpStatusCode.Created, "Se ha modificado correctamente con pid = $countryPid")
                } ?: run {
                    call.respond(HttpStatusCode.BadRequest, "Debes identificar el pais")
                    return@patch
                }
            } catch (error: IllegalArgumentException) {
                call.respond(HttpStatusCode.BadRequest, error.localizedMessage)
            } catch (error: JsonConvertException) {
                call.respond(HttpStatusCode.BadRequest, error.localizedMessage)
            }
        }

        // Petición DELETE para eliminar un país
        delete("/country/{pid}") {
            val countryPid = call.parameters["pid"]
            logger.warn("Queremos borrar el pais con el $countryPid")
            countryPid?.let {
                val deleted = ProviderUseCase.deleteCountry(countryPid)
                if (!deleted) {
                    call.respond(HttpStatusCode.NotFound, "País no encontrado para borrar")
                } else {
                    call.respond(HttpStatusCode.NoContent)
                }
            } ?: run {
                call.respond(HttpStatusCode.BadRequest, "Debes identificar el pais")
            }
            return@delete
        }
        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}