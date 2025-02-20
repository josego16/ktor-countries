package data.persistence.models.user

import org.jetbrains.exposed.dao.id.IntIdTable

object UserTable: IntIdTable("User") {
    val username = varchar("username", 100).uniqueIndex()
    val password = varchar("password", 255)
    val token = varchar("token", 255).nullable()
}