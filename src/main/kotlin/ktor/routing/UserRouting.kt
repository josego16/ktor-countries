package ktor.routing

import domain.user.usecase.ProviderUserUseCase
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.userRouting() {
    route("/user") {
        get {
            val user = ProviderUserUseCase.allUsers()
            call.respond(user)
        }
    }
}