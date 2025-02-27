package domain.country.mapping

import data.persistence.country.models.CountryDao
import domain.country.models.country.Country
import domain.country.models.country.UpdateCountry
import domain.country.models.enums.Language

fun countryDaoToCountry(countryDao: CountryDao): Country {
    val coun = Country(
        countryDao.pid,
        countryDao.name,
        countryDao.capital,
        countryDao.language.toLanguageOrDefault(),
        countryDao.famousEvent,
        countryDao.typicalGastronomy,
        countryDao.flagUrl ?: "null"
    )
    return coun
}

fun updateCountryToCountry(existing: Country, update: UpdateCountry): Country {
    return Country(
        pid = existing.pid,  // El PID nunca cambia
        name = update.name ?: existing.name,  // Mantener valor original si es null
        capital = update.capital ?: existing.capital,
        language = update.language ?: existing.language,
        famousEvent = update.famousEvent ?: existing.famousEvent,
        typicalGastronomy = update.typicalGastronomy ?: existing.typicalGastronomy,
        flagUrl = update.flagUrl ?: existing.flagUrl
    )
}

fun String.toLanguageOrDefault(): Language {
    return try {
        Language.valueOf(this)
    } catch (error: IllegalArgumentException) {
        Language.Unknown
    }
}