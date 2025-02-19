package domain.models.user

import kotlinx.serialization.Serializable

@Serializable
data class UpdateUser(
    val id: Int? = null,
    val username: String? = null,
    val password: String? = null,
    val token: String? = null
)