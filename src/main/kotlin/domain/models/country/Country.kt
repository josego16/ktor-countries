package domain.models.country

import domain.models.enums.Language
import domain.models.enums.OlympicEvent
import domain.models.enums.Sport
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val pid: String,
    val name: String,
    val country: String,
    val language: Language,
    val hostedOlympic: List<OlympicEvent>,
    val activeSport: List<Sport>,
    val flagUrl: String? = null
)