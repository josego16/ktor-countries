package domain.country.models.country

import domain.country.models.enums.Events
import domain.country.models.enums.Gastronomy
import domain.country.models.enums.Language
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val pid: String,
    val name: String,
    val capital: String,
    val language: Language,
    val famousEvent: Events,
    val typicalGastronomy: Gastronomy,
    val flagUrl: String? = null
)