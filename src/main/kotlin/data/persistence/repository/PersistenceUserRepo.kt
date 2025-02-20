package data.persistence.repository

import data.persistence.models.suspendedTransaction
import data.persistence.models.user.UserDao
import data.security.PasswordHash
import domain.mapping.userDaoToUser
import domain.models.user.UpdateUser
import domain.models.user.User
import domain.repository.UserInterface

class PersistenceUserRepo : UserInterface {
    override suspend fun login(username: String, passwd: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun register(user: UpdateUser): User? {
        return try {
            suspendedTransaction {
                UserDao.new {
                    this.username = user.username!!
                    this.password = PasswordHash.hash(user.password!!)
                    this.token = user.token!!
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