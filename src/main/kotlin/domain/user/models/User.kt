package domain.user.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val dni: String,
    val name: String,
    val phone: String,
    val username: String,
    val password: String,
    var token: String? = null,
)