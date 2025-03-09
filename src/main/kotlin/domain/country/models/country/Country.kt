package domain.country.models.country

import domain.country.models.enums.Language
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val pid: String,
    val name: String,
    val capital: String,
    val language: Language,
    val famousEvent: String,
    val typicalGastronomy: String,
    var flagUrl: String? = null
)