package domain.user.repository

import domain.user.models.UpdateUser
import domain.user.models.User

interface UserInterface {
    suspend fun allUsers(): List<User>
    suspend fun userByDni(dni: String): User?
    suspend fun login(dni: String, pass: String): User?
    suspend fun register(updateUser: UpdateUser): User?
}