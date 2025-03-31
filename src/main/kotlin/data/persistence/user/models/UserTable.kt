package data.persistence.user.models

import org.jetbrains.exposed.dao.id.IntIdTable

object UserTable : IntIdTable("User") {
    var dni = varchar("dni", 50).uniqueIndex()
    var name = varchar("name", 255)
    var phone = varchar("phone", 255)
    val username = varchar("username", 100)
    val password = varchar("password", 255)
    val token = varchar("token", 255).nullable()
}