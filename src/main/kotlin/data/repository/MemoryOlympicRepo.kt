package data.repository

import data.models.OlympicData
import domain.models.Country
import domain.models.UpdateCountry
import domain.models.enums.Language
import domain.repository.CountryInterface

class MemoryOlympicRepo : CountryInterface {
    override fun allCountries(): List<Country> {
        return OlympicData.listCountry
    }

    override fun countriesByLanguage(language: Language): List<Country> {
        return OlympicData.listCountry.filter { it.language == language }
    }

    override fun countryByName(name: String): Country? {
        return OlympicData.listCountry.find { it.name.equals(name, ignoreCase = true) }
    }

    override fun countryById(id: Int): Country? {
        return OlympicData.listCountry.find { it.id == id }
    }

    override fun addCountry(country: Country): Boolean {
        val coun = countryById(country.id)
        return if (coun != null) {
            throw IllegalArgumentException("No es posible añadir un pais que ya existe")
        } else {
            OlympicData.listCountry.add(country)
            true
        }
    }

    override fun updateCountry(updateCountry: UpdateCountry, id: Int): Boolean {
        val index = OlympicData.listCountry.indexOfFirst { it.id == id }
        return if (index != -1) {
            val currentCountry = OlympicData.listCountry[index]
            OlympicData.listCountry[index] = currentCountry.copy(
                name = updateCountry.name ?: currentCountry.name,
                language = updateCountry.language ?: currentCountry.language,
                hostedOlympics = updateCountry.hostedOlympics ?: currentCountry.hostedOlympics,
                activeSport = updateCountry.activeSport ?: currentCountry.activeSport,
                flagUrl = updateCountry.flagUrl ?: currentCountry.flagUrl
            )
            true
        } else {
            false
        }
    }

    override fun deleteCountry(id: Int): Boolean {
        return OlympicData.listCountry.removeIf { it.id == id }
    }
}