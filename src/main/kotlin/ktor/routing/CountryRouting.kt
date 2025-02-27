package ktor.routing

import domain.country.models.country.Country
import domain.country.models.country.UpdateCountry
import domain.country.models.enums.Language
import domain.country.usecase.ProviderCountryUseCase
import domain.country.usecase.ProviderCountryUseCase.logger
import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json

fun Routing.countryRouting() {
    route("/country") {

        // Peticion GET para obtener todos los paises
        get {
            val country = ProviderCountryUseCase.allCountries()
            call.respond(country)
        }
        // Petición GET para obtener un pais
        get("/{pid}") {
            val countryPid = call.parameters["pid"]
            logger.warn("El pid tiene valor de $countryPid")
            if (countryPid != null) {
                val country = ProviderCountryUseCase.countryById(countryPid)
                if (country == null) {
                    call.respond(HttpStatusCode.NotFound, "País no encontrado")
                } else {
                    call.respond(country)
                }
                return@get
            }
        }
        get("/{language}") {
            val language = call.parameters["language"]
            logger.warn("Language tiene valor de $language")
            if (language != null) {
                try {
                    val lang = language.uppercase()
                    logger.warn("Lenguaje seleccionado: ${Language.valueOf(lang)}")
                    val countries = ProviderCountryUseCase.countryByLanguage(Language.valueOf(lang.uppercase()))
                    call.respond(countries)
                } catch (e: IllegalArgumentException) {
                    call.respond(HttpStatusCode.BadRequest, "Lenguaje no válido")
                }
            } else {
                val allCountries = ProviderCountryUseCase.allCountries()
                call.respond(allCountries)
            }
            return@get
        }

        // Petición POST para agregar un nuevo país
        post {
            try {
                val country = call.receive<Country>()
                val newCountry = ProviderCountryUseCase.addCountry(country)
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
        patch("/{pid}") {
            try {
                val requestBody = call.receiveText()
                val updatedData = Json.decodeFromString<UpdateCountry>(requestBody)

                val countryPid = call.parameters["pid"]
                if (countryPid == null) {
                    call.respond(HttpStatusCode.BadRequest, "Debes identificar el país")
                    return@patch
                }

                val updatedCountry = ProviderCountryUseCase.updateCountry(updatedData, countryPid)
                if (!updatedCountry) {
                    call.respond(HttpStatusCode.Conflict, "El país no puede modificarse, puede que ya exista")
                    return@patch
                }
                call.respond(HttpStatusCode.Created, "Se ha modificado correctamente con pid = $countryPid")
            } catch (e: Exception) {
                println("Error: ${e.message}")  // Log del error
                call.respond(HttpStatusCode.BadRequest, "Error en la petición: ${e.message}")
            }
        }


        // Petición DELETE para eliminar un país
        delete("/{pid}") {
            val countryPid = call.parameters["pid"]
            logger.warn("Queremos borrar el pais con el $countryPid")
            countryPid?.let {
                val deleted = ProviderCountryUseCase.deleteCountry(countryPid)
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
    }
}