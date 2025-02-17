package domain.models

import domain.models.enums.Language
import domain.models.enums.OlympicEvent
import domain.models.enums.Sport
import kotlinx.serialization.Serializable

@Serializable
data class UpdateCountry(
    val id: Int? = null,
    val name: String? = null,
    val country: String? = null,
    val language: Language? = null,
    val hostedOlympics: List<OlympicEvent>? = emptyList(),
    val activeSport: List<Sport>? = emptyList(),
    val flagUrl: String? = null
)