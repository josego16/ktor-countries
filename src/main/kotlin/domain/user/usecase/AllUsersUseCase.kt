package domain.user.usecase

import domain.user.models.User
import domain.user.repository.UserInterface

class AllUsersUseCase(val repository: UserInterface) {
    suspend operator fun invoke(): List<User> {
        return repository.allUsers()
    }
}