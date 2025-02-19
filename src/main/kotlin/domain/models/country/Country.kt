package domain.models.country

import domain.models.enums.Language
import domain.models.enums.OlympicEvent
import domain.models.enums.Sport
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val id: Int,
    val name: String,
    val country: String,
    val language: Language,
    val hostedOlympics: List<OlympicEvent>,
    val activeSport: List<Sport>,
    val flagUrl: String? = null
)