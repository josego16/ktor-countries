package ktor

import domain.user.security.JwtConfig
import domain.user.usecase.ProviderUserUseCase
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureSecurity() {
    install(Authentication) {
        jwt("jwt-auth") {
            JwtConfig.configureAuthentication(this)
        }
    }
    routing {
        authenticate("jwt-auth") {
            get("/protected") {
                val principal = call.principal<JWTPrincipal>()
                val username = principal?.getClaim("username", String::class)
                call.respondText("Hello, $username! You are authenticated.")
            }
        }
    }
}

suspend fun ApplicationCall.validateToken(token: String): Boolean {
    val dataUser = this.principal<JWTPrincipal>()
    val dni = dataUser?.payload?.getClaim("dni")?.asString()

    val user = ProviderUserUseCase.userByDni(dni!!)
    if (user == null || token != user.token) {
        this.respond(HttpStatusCode.Unauthorized, "Token invalid.")
        return false
    } else {
        return true
    }
}
