package data.persistence.user.repository

import data.persistence.suspendedTransaction
import data.persistence.user.models.UserDao
import data.persistence.user.security.PasswordHash
import domain.user.mapping.userDaoToUser
import domain.user.models.UpdateUser
import domain.user.models.User
import domain.user.repository.UserInterface

class PersistenceUserRepo : UserInterface {
    override suspend fun allUsers(): List<User> {
        TODO("Not yet implemented")
    }

    override suspend fun userbyUsername(username: String): List<User> {
        TODO("Not yet implemented")
    }

    override suspend fun userByDni(dni: String): User? {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(updateUser: UpdateUser, dni: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(dni: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun login(dni: String, passwd: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun register(updateUser: UpdateUser): User? {
        return try {
            suspendedTransaction {
                UserDao.new {
                    this.username = updateUser.username!!
                    this.password = PasswordHash.hash(updateUser.password!!)
                    this.token = updateUser.token!!
                }
            }.let {
                null
                userDaoToUser(it)
            }
        } catch (error: Exception) {
            println("Error en el registro del usuario: ${error.localizedMessage}")
            null
        }
    }
}