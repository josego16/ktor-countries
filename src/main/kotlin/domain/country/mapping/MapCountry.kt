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

fun updateCountryToCountry(country: UpdateCountry): Country {
    val coun = Country(
        country.pid!!,
        country.name!!,
        country.capital!!,
        country.language!!,
        country.famousEvent!!,
        country.tpycalGastronomy!!,
        country.flagUrl ?: "",
    )
    return coun
}

fun String.toLanguageOrDefault(): Language {
    return try {
        Language.valueOf(this)
    } catch (error: IllegalArgumentException) {
        Language.ENGLISH
    }
}