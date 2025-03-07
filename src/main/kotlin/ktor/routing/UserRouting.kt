package ktor.routing

import domain.user.mapping.toUpdateUser
import domain.user.models.UpdateUser
import domain.user.models.User
import domain.user.usecase.ProviderUserUseCase
import domain.user.usecase.ProviderUserUseCase.logger
import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.userRouting() {
    route("/user") {

        // Petición GET para obtener todos los usuarios
        get {
            val user = ProviderUserUseCase.allUsers()
            call.respond(user)
        }

        // Petición GET para obtener un usuario
        get("/{dni}") {
            val userId = call.parameters["dni"]
            logger.warn("El pid tiene valor de $userId")
            if (userId != null) {
                val user = ProviderUserUseCase.userByDni(userId)
                if (user == null) {
                    call.respond(HttpStatusCode.NotFound, "Usuario no encontrado")
                } else {
                    call.respond(user)
                }
                return@get
            }
        }

        //Petición para realizar el login.
        post("/login") {
            try {
                val loginRequest = call.receive<UpdateUser>()
                val login: User? = ProviderUserUseCase.login(loginRequest.dni, loginRequest.password)

                if (login != null) {
                    val usr = login.toUpdateUser()
                    usr.token = login.token
                    usr.msg = "Usuario logueado correctamente"
                    call.respond(HttpStatusCode.OK, usr)
                } else {
                    call.respond(HttpStatusCode.BadRequest, "Problemas de autenticacion")
                }
            } catch (error: Exception) {
                call.respond(HttpStatusCode.BadRequest, "Formato de solicitud incorrecta")
                return@post
            }
        }

        //Petición para realizar el registro.
        post("/register") {
            try {
                val user = call.receive<UpdateUser>()
                val register = ProviderUserUseCase.register(user)

                if (register != null) {
                    val upEmp = register.toUpdateUser()
                    upEmp.msg = "Usuario con dni =  ${upEmp.dni}, registrado correctamente. Vuelva a loguearse"
                    call.respond(HttpStatusCode.Created, upEmp)
                } else {
                    call.respond(HttpStatusCode.Conflict, "No se ha podido realizar el registro")
                }
            } catch (e: IllegalStateException) {
                call.respond(HttpStatusCode.BadRequest, "Error en el formato de envío de datos o lectura del cuerpo.")
            } catch (e: JsonConvertException) {
                call.respond(HttpStatusCode.BadRequest, " Problemas en la conversión json")
            }
        }
    }
}