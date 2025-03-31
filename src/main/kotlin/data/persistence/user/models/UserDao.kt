package data.persistence.user.models

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UserDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserDao>(UserTable)

    var dni by UserTable.dni
    var name by UserTable.name
    var phone by UserTable.phone
    var username by UserTable.username
    var password by UserTable.password
    var token by UserTable.token
}