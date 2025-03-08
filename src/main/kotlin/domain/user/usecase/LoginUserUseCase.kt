package domain.user.usecase

import domain.user.models.User
import domain.user.repository.UserInterface
import domain.user.security.JwtConfig

class LoginUserUseCase(val repository: UserInterface) {
    suspend operator fun invoke(dni: String?, pass: String?): User? {
        if (dni.isNullOrBlank() || pass.isNullOrBlank()) return null

        return try {
            val user = repository.login(dni, pass)
            user?.let {
                val token = JwtConfig.generateToken(it.dni)
                repository.updateToken(it.dni, token)
                it.copy(token = token)
            }
        } catch (error: Exception) {
            println("Error en login: ${error.localizedMessage}")
            null
        }
    }
}