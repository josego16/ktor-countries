package domain.user.usecase

import domain.user.models.User
import domain.user.repository.UserInterface

class UserByUsernameUseCase(val repository: UserInterface) {
    var filter: String? = null
    suspend operator fun invoke(): List<User> {
        return filter?.let {
            repository.userbyUsername(it)
        } ?: run {
            emptyList()
        }
    }
}