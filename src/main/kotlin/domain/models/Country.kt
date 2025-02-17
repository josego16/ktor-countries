package domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val id: Int,
    val name: String,
    val country: String,
    val language: Language,
    val hostedOlympics: List<OlympicEvent> = emptyList(),
    val activeSport: List<Sport> = emptyList(),
    val flagUrl: String? = null
)