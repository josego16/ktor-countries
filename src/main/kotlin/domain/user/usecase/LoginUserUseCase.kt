package domain.user.usecase

import domain.user.repository.UserInterface

class LoginUserUseCase(val repository: UserInterface) {
    suspend operator fun invoke(dni: String?, passwd: String?): Boolean {
        if (dni.isNullOrBlank() || passwd.isNullOrBlank()) {
            return false
        }
        return try {
            val us = repository.login(dni, passwd)
            us
        } catch (error: Exception) {
            println("Error en el login: ${error.localizedMessage}")
            false
        }
    }
}