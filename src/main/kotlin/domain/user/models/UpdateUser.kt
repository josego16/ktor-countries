package domain.user.models

import kotlinx.serialization.Serializable

@Serializable
data class UpdateUser(
    var dni: String? = null,
    var username: String? = null,
    var password: String? = null,
    var name: String? = null,
    var phone: String? = null,
    var token: String? = null
)