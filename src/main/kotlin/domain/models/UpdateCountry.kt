package domain.models

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