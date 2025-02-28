package data.persistence.user.repository

import data.persistence.suspendedTransaction
import data.persistence.user.models.UserDao
import data.persistence.user.models.UserTable
import data.persistence.user.security.PasswordHash
import domain.user.mapping.toUser
import domain.user.models.UpdateUser
import domain.user.models.User
import domain.user.repository.UserInterface

class PersistenceUserRepo : UserInterface {
    override suspend fun allUsers(): List<User> {
        return suspendedTransaction {
            UserDao.all().map { it.toUser() }
        }
    }

    override suspend fun userByDni(dni: String): User? {
        return suspendedTransaction {
            UserDao.find {
                UserTable.dni eq dni
            }.limit(1).map { it.toUser() }.firstOrNull()
        }
    }

    override suspend fun login(dni: String, pass: String): User? {
        val user = userByDni(dni) ?: return null

        return try {
            if (PasswordHash.verify(pass, user.password)) {
                user
            } else {
                null
            }
        } catch (error: Exception) {
            println("Error en la autenticacion: ${error.localizedMessage}")
            null
        }
    }

    override suspend fun register(updateUser: UpdateUser): User? {
        return try {
            suspendedTransaction {
                UserDao.new {
                    this.dni = updateUser.dni!!
                    this.name = updateUser.name!!
                    this.phone = updateUser.phone!!
                    this.username = updateUser.username!!
                    this.password = PasswordHash.hash(updateUser.password!!)
                    this.token = updateUser.token!!
                }
            }.toUser()
        } catch (error: Exception) {
            println("Error al registrar el usuario: ${error.localizedMessage}")
            null
        }
    }
}