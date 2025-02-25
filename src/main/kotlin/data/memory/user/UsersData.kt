package data.memory.user

import domain.user.models.User

object UsersData {
    val listUsers = mutableListOf(
        User(
            dni = "1",
            username = "josego",
            password = "josema",
            name = "Josema",
            phone = "000000000",
            token = "",
        ),
        User(
            dni = "2",
            username = "jaimego",
            password = "jaime",
            name = "Jaime",
            phone = "000004002",
            token = "",
        ),
    )
}