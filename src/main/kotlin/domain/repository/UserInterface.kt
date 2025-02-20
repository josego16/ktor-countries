package domain.repository

import domain.models.user.UpdateUser
import domain.models.user.User

interface UserInterface {
    suspend fun login(username: String, passwd: String): Boolean  //
    suspend fun register(user: UpdateUser): User?
}