package data.memory.user

import domain.user.models.UpdateUser
import domain.user.models.User
import domain.user.repository.UserInterface

class MemoryUserRepo : UserInterface {
    override suspend fun allUsers(): List<User> {
        TODO("Not yet implemented")
    }

    override suspend fun userByDni(dni: String): User? {
        TODO("Not yet implemented")
    }

    override suspend fun login(dni: String, pass: String): User? {
        TODO("Not yet implemented")
    }

    override suspend fun register(updateUser: UpdateUser): User? {
        TODO("Not yet implemented")
    }
}