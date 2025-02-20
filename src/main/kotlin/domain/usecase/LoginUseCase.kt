package domain.usecase

import domain.repository.UserInterface

class LoginUseCase(val repository: UserInterface) {
    suspend operator fun invoke(username: String?, passwd: String?): Boolean {
        return if (username.isNullOrBlank() || passwd.isNullOrBlank()) {
            false
        } else {
            try {
                val res = repository.login(username, passwd)
                res
            } catch (error: Exception) {
                println("Error en el login: ${error.localizedMessage}")
                false
            }
        }
    }
}