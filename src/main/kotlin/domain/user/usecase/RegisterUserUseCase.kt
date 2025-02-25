package domain.user.usecase

import domain.user.models.UpdateUser
import domain.user.models.User
import domain.user.repository.UserInterface

class RegisterUserUseCase(val repository: UserInterface) {
    suspend operator fun invoke(updateUser: UpdateUser): User? {
        updateUser.dni = updateUser.dni!!
        updateUser.username = updateUser.username!!
        updateUser.password = updateUser.password!!
        updateUser.phone = updateUser.phone ?: "0000000"
        updateUser.token = updateUser.token ?: ""

        return if (repository.login(updateUser.dni!!, updateUser.password!!))
            null
        else
            repository.register(updateUser)
    }
}