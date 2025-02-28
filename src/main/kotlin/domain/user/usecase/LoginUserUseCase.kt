package domain.user.usecase

import domain.user.models.User
import domain.user.repository.UserInterface

class LoginUserUseCase(val repository: UserInterface) {
    suspend operator fun invoke(dni: String?, pass: String?): User? {
        if (dni.isNullOrBlank() || pass.isNullOrBlank()) return null

        return try {
            repository.login(dni, pass)
        } catch (error: Exception) {
            println("Error en login: ${error.localizedMessage}")
            null
        }
    }
}