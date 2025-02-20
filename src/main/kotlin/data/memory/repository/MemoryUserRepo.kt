package data.memory.repository

import domain.models.user.UpdateUser
import domain.models.user.User
import domain.repository.UserInterface

class MemoryUserRepo : UserInterface {
    override suspend fun login(username: String, passwd: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun register(user: UpdateUser): User? {
        TODO("Not yet implemented")
    }
}