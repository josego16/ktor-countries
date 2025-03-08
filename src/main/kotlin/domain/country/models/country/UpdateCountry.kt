package domain.country.models.country

import domain.country.models.enums.Language
import kotlinx.serialization.Serializable

@Serializable
data class UpdateCountry(
    val pid: String? = null,
    val name: String? = null,
    val capital: String? = null,
    val language: Language? = null,
    val famousEvent: String? = null,
    val typicalGastronomy: String? = null,
    val flagUrl: String? = null,
    var msg: String? = null,
)