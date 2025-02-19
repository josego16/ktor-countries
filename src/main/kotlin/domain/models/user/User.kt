package domain.models.user

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val username: String,
    val password: String,
    val token: String? = null,
)