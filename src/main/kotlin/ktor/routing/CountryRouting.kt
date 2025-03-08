package ktor.routing

import domain.country.mapping.toUpdateCountry
import domain.country.models.country.Country
import domain.country.models.country.UpdateCountry
import domain.country.models.enums.Language
import domain.country.usecase.ProviderCountryUseCase
import domain.country.usecase.ProviderCountryUseCase.logger
import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import ktor.validateToken

fun Routing.countryRouting() {
    route("/country") {
        authenticate("jwt-auth") {

            // Peticion GET para obtener todos los paises
            get {
                val token = call.request.headers["Authorization"]?.removePrefix("Bearer ")
                val validate = call.validateToken(token!!)
                if (!validate) {
                    return@get
                }
                val country = ProviderCountryUseCase.allCountries()
                call.respond(country)
            }

            // Petición GET para obtener un pais
            get("/{pid}") {
                val token = call.request.headers["Authorization"]?.removePrefix("Bearer ")
                val validate = call.validateToken(token!!)
                if (!validate) {
                    return@get
                }
                val countryPid = call.parameters["pid"]
                logger.warn("El pid tiene valor de $countryPid")
                if (countryPid != null) {
                    val country = ProviderCountryUseCase.countryById(countryPid)
                    if (country == null) {
                        call.respond(HttpStatusCode.NotFound, "País no encontrado")
                    } else {
                        val upCountry = country.toUpdateCountry()
                        upCountry.msg = "Country OK"
                        call.respond(upCountry)
                    }
                    return@get
                }
            }

            // Petición GET para obtener los paises con un lenguaje específico
            get("/language/{language}") {
                val token = call.request.headers["Authorization"]?.removePrefix("Bearer ")
                val validate = call.validateToken(token!!)
                if (!validate) {
                    return@get
                }
                val language = call.parameters["language"]
                logger.warn("Language tiene valor de $language")

                if (language != null) {
                    val lang = language.trim()
                    val validLanguage = Language.entries.find { it.name.equals(lang, ignoreCase = true) }

                    if (validLanguage != null) {
                        logger.warn("Lenguaje seleccionado: $validLanguage")
                        val countries = ProviderCountryUseCase.countryByLanguage(validLanguage)
                        call.respond(countries)
                    } else {
                        logger.warn("Error: Lenguaje no válido")
                        call.respond(HttpStatusCode.BadRequest, "Lenguaje no válido")
                    }
                } else {
                    val allCountries = ProviderCountryUseCase.allCountries()
                    call.respond(allCountries)
                }
            }

            // Petición POST para agregar un nuevo país
            post {
                val token = call.request.headers["Authorization"]?.removePrefix("Bearer ")
                val validate = call.validateToken(token!!)
                if (!validate) {
                    return@post
                }
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
                val token = call.request.headers["Authorization"]?.removePrefix("Bearer ")
                val validate = call.validateToken(token!!)
                if (!validate) {
                    return@patch
                }
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
                    println("Error: ${e.message}")
                    call.respond(HttpStatusCode.BadRequest, "Error en la petición: ${e.message}")
                }
            }


            // Petición DELETE para eliminar un país
            delete("/{pid}") {
                val token = call.request.headers["Authorization"]?.removePrefix("Bearer ")
                val validate = call.validateToken(token!!)
                if (!validate) {
                    return@delete
                }
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
}