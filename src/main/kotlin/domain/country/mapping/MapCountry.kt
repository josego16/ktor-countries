package domain.country.mapping

import data.persistence.country.models.CountryDao
import domain.country.models.country.Country
import domain.country.models.country.UpdateCountry
import domain.country.models.enums.Language

fun Country.toUpdateCountry(): UpdateCountry {
    return UpdateCountry(
        pid = pid,
        name = name,
        capital = capital,
        language = language,
        famousEvent = famousEvent,
        typicalGastronomy = typicalGastronomy,
        flagUrl = flagUrl,
    )
}

fun UpdateCountry.toCountry(): Country {
    return Country(
        pid = pid!!,
        name = name!!,
        capital = capital!!,
        language = language!!,
        famousEvent = famousEvent!!,
        typicalGastronomy = typicalGastronomy!!,
        flagUrl = flagUrl!!
    )
}

fun CountryDao.toCountry(): Country {
    val coun = Country(
        pid,
        name,
        capital,
        language.toLanguageOrDefault(),
        famousEvent,
        typicalGastronomy,
        flagUrl ?: "null"
    )
    return coun
}

fun String.toLanguageOrDefault(): Language {
    return try {
        Language.valueOf(this)
    } catch (error: IllegalArgumentException) {
        Language.Unknown
    }
}