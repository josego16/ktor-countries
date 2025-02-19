package data.memory.repository

import data.memory.models.OlympicData
import domain.models.country.Country
import domain.models.country.UpdateCountry
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

    override fun addCountry(country: Country): Country? {
        val coun = countryById(country.id)
        return if (coun != null) {
            null
        } else {
            try {
                OlympicData.listCountry.add(country)
                country
            } catch (error: Exception) {
                null
            }
        }
    }

    override fun updateCountry(updateCountry: UpdateCountry, id: Int): Country? {
        return try {
            val index = OlympicData.listCountry.indexOfFirst { it.id == id }
            if (index != -1) {
                val currentCountry = OlympicData.listCountry[index]
                val updatedCountry = currentCountry.copy(
                    name = updateCountry.name ?: currentCountry.name,
                    language = updateCountry.language ?: currentCountry.language,
                    hostedOlympics = updateCountry.hostedOlympics ?: currentCountry.hostedOlympics,
                    activeSport = updateCountry.activeSport ?: currentCountry.activeSport,
                    flagUrl = updateCountry.flagUrl ?: currentCountry.flagUrl
                )
                OlympicData.listCountry[index] = updatedCountry
                updatedCountry
            } else {
                null
            }
        } catch (error: Exception) {
            null
        }
    }

    override fun deleteCountry(id: Int): Boolean {
        return OlympicData.listCountry.removeIf { it.id == id }
    }
}