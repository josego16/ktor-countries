package domain.user.usecase

import domain.user.models.UpdateUser
import domain.user.models.User
import domain.user.repository.UserInterface

class RegisterUserUseCase(val repository: UserInterface) {
    suspend operator fun invoke(updateUser: UpdateUser): User? {
        updateUser.dni = updateUser.dni!!
        updateUser.name = updateUser.name!!
        updateUser.phone = updateUser.phone?:"000000000"
        updateUser.username = updateUser.username!!
        updateUser.password = updateUser.password!!
        updateUser.token = updateUser.token ?: ""

        return if (repository.login(updateUser.dni!!, updateUser.password!!) != null) {
            null
        } else {
            repository.register(updateUser)
        }
    }
}