package domain.user.usecase

import domain.user.models.User
import domain.user.repository.UserInterface

class UserByDniUseCase(val repository: UserInterface) {
    var dni: String? = null
    suspend operator fun invoke(): User? {
        return if (dni?.isBlank() == true) {
            null
        } else {
            repository.userByDni(dni!!)
        }
    }
}