package domain.user.mapping

import data.persistence.user.models.UserDao
import domain.user.models.UpdateUser
import domain.user.models.User

fun userDaoToUser(userDao: UserDao): User {
    val user = User(
        userDao.dni,
        userDao.username,
        userDao.password,
        userDao.name,
        userDao.phone,
        userDao.token ?: "null",
    )
    return user
}

fun updateUserToUser(user: UpdateUser): User {
    return User(
        user.dni!!,
        user.username!!,
        user.password!!,
        user.name!!,
        user.phone!!,
        user.token ?: ""
    )
}