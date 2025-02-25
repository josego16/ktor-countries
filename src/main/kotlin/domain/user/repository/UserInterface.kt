package domain.user.repository

import domain.user.models.UpdateUser
import domain.user.models.User

interface UserInterface {
    suspend fun allUsers(): List<User>
    suspend fun userbyUsername(username: String): List<User>
    suspend fun userByDni(dni: String): User?
    suspend fun updateUser(updateUser: UpdateUser, dni: String): Boolean
    suspend fun deleteUser(dni: String): Boolean
    suspend fun login(dni: String, passwd: String): Boolean
    suspend fun register(updateUser: UpdateUser): User?
}