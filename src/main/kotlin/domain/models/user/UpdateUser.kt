package domain.models.user

import kotlinx.serialization.Serializable

@Serializable
data class UpdateUser(
    var username: String? = null,
    var password: String? = null,
    var token: String? = null
)