package data.memory.country

import domain.country.models.country.Country
import domain.country.models.country.UpdateCountry
import domain.country.models.enums.Language
import domain.country.repository.CountryInterface

class MemoryCountryRepo : CountryInterface {
    override suspend fun allCountries(): List<Country> {
        return CountriesData.listCountry
    }

    override suspend fun countriesByLanguage(language: Language): List<Country> {
        return CountriesData.listCountry.filter { it.language == language }
    }

    override suspend fun countryByName(name: String): Country? {
        return CountriesData.listCountry.find { it.name.equals(name, ignoreCase = true) }
    }

    override suspend fun countryByPid(pid: String): Country? {
        return CountriesData.listCountry.find { it.pid == pid }
    }

    override suspend fun postCountry(country: Country): Country? {
        val coun = countryByPid(country.pid)
        return if (coun != null) {
            null
        } else {
            try {
                CountriesData.listCountry.add(country)
                country
            } catch (error: Exception) {
                null
            }
        }
    }

    override suspend fun updateCountry(updateCountry: UpdateCountry, pid: String): Country? {
        return try {
            val index = CountriesData.listCountry.indexOfFirst { it.pid == pid }
            if (index != -1) {
                val currentCountry = CountriesData.listCountry[index]
                val updatedCountry = currentCountry.copy(
                    name = updateCountry.name ?: currentCountry.name,
                    language = updateCountry.language ?: currentCountry.language,
                    famousEvent = updateCountry.famousEvent ?: currentCountry.famousEvent,
                    typicalGastronomy = updateCountry.typicalGastronomy ?: currentCountry.typicalGastronomy,
                    flagUrl = updateCountry.flagUrl ?: currentCountry.flagUrl
                )
                CountriesData.listCountry[index] = updatedCountry
                updatedCountry
            } else {
                null
            }
        } catch (error: Exception) {
            null
        }
    }

    override suspend fun deleteCountry(pid: String): Boolean {
        return CountriesData.listCountry.removeIf { it.pid == pid }
    }
}