package domain.models.country

import domain.models.enums.Language
import domain.models.enums.OlympicEvent
import domain.models.enums.Sport
import kotlinx.serialization.Serializable

@Serializable
data class UpdateCountry(
    val pid: String? = null,
    val name: String? = null,
    val country: String? = null,
    val language: Language? = null,
    val hostedOlympics: List<OlympicEvent>? = emptyList(),
    val activeSport: List<Sport>? = emptyList(),
    val flagUrl: String? = null
)