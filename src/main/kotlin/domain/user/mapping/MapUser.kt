package domain.user.mapping

import data.persistence.user.models.UserDao
import domain.user.models.UpdateUser
import domain.user.models.User

fun User.toUpdateUser(): UpdateUser {
    return UpdateUser(
        dni = dni,
        name = name,
        phone = phone,
        username = username,
        password = password,
        token = token
    )
}

fun UpdateUser.toUser(): User {
    return User(
        dni = dni!!,
        name = name!!,
        phone = phone!!,
        username = username!!,
        password = password!!,
        token = token!!
    )
}

fun UserDao.toUser(): User {
    val us = User(
        this.dni,
        this.name,
        this.phone,
        this.username,
        this.password,
        this.token ?: "null"
    )
    return us
}
