package data.memory.models

import domain.models.user.User

object UsersData {
    val listUsers = mutableListOf(
        User(
            username = "josema",
            password = "josema",
            token = "",
        ),
        User(
            username = "jaime",
            password = "jaime",
            token = "",
        ),
    )
}