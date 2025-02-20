package domain.usecase

import domain.models.user.UpdateUser
import domain.models.user.User
import domain.repository.UserInterface

class RegisterUseCase(val repository: UserInterface) {
    suspend operator fun invoke(user: UpdateUser): User? {
        user.username = user.username!!
        user.password = user.password!!
        user.token = user.token ?: ""

        return if (repository.login(user.username!!, user.password!!)) {
            null
        } else {
            repository.register(user)
        }
    }
}