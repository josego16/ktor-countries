package domain.user.usecase

import data.persistence.user.repository.PersistenceUserRepo
import domain.user.models.UpdateUser
import domain.user.models.User
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object ProviderUserUseCase {
    private val repository = PersistenceUserRepo()
    val logger: Logger = LoggerFactory.getLogger("UserUseCaseLogger")

    private val allUsersUseCase = AllUsersUseCase(repository)
    private val userByDniUseCase = UserByDniUseCase(repository)
    private val loginUserUseCase = LoginUserUseCase(repository)
    private val registerUserUseCase = RegisterUserUseCase(repository)

    suspend fun allUsers() = allUsersUseCase()

    suspend fun userByDni(dni: String): User? {
        if (dni.isBlank()) {
            logger.warn("El dni esta vacio o no existe")
            return null
        }
        userByDniUseCase.dni = dni
        val use = userByDniUseCase()

        return if (use == null) {
            logger.warn("No se ha encontrado un empleado con ese $dni")
            null
        } else {
            use
        }
    }

    suspend fun login(dni: String?, passwd: String?): User? {
        return loginUserUseCase(dni, passwd)
    }

    suspend fun register(updateUser: UpdateUser): User? {
        return if (
            updateUser.dni.isNullOrBlank() ||
            updateUser.username.isNullOrBlank() ||
            updateUser.password.isNullOrBlank()
        ) {
            null
        } else {
            registerUserUseCase(updateUser)
        }
    }
}