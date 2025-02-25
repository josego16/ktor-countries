package domain.user.usecase

import domain.user.models.UpdateUser
import domain.user.repository.UserInterface

class UpdateUserUseCase(val repository: UserInterface) {
    var updateUser: UpdateUser? = null
    var dni: String? = null

    suspend operator fun invoke(): Boolean {
        return if (updateUser == null || dni == null) {
            false
        } else {
            return repository.updateUser(updateUser!!, dni!!)
        }
    }
}