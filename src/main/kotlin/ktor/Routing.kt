package ktor

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ktor.routing.countryRouting
import ktor.routing.imgRouting
import ktor.routing.userRouting
import java.io.File

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        userRouting()
        countryRouting()
        imgRouting()

        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")

        staticFiles("/images", File("upload/images"))
        staticFiles("/files", File("upload/files"))
    }
}