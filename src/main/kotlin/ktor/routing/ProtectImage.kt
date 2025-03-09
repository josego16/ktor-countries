package ktor.routing

import io.ktor.http.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ktor.ApplicationContext
import ktor.validateToken
import java.io.File

fun Route.imgRouting() {
    route("/images/{pid}/{image}") {
        authenticate("jwt-auth") {
            get {
                val token = call.request.headers["Authorization"]?.removePrefix("Bearer ")
                val validate = call.validateToken(token!!)

                if (!validate) {
                    return@get
                }
                val pid = call.parameters["pid"] ?: return@get call.respond(HttpStatusCode.BadRequest, "Necesitamos el pid")
                val nameImage = call.parameters["image"] ?: return@get call.respond(HttpStatusCode.BadRequest, "Necesitamos la imagen")

                val path =
                    ApplicationContext.context.environment.config.property("ktor.path.images").getString() + "/$pid"
                val img = File(path, nameImage)

                if (!img.exists()) {
                    return@get call.respond(HttpStatusCode.BadRequest, "Imagen no encontrada")
                }
                call.respondFile(img)
            }
        }
    }
}