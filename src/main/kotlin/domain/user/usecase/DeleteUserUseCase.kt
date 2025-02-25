package domain.user.usecase

import domain.user.repository.UserInterface

class DeleteUserUseCase(val repository: UserInterface) {
    var dni: String? = null
    suspend operator fun invoke(): Boolean {
        return if (dni == null) {
            false
        } else {
            return repository.deleteUser(dni!!)
        }
    }
}