package domain.repository

import domain.models.country.Country
import domain.models.country.UpdateCountry
import domain.models.enums.Language

interface CountryInterface {
    suspend fun allCountries(): List<Country>
    suspend fun countriesByLanguage(language: Language): List<Country>
    suspend fun countryByName(name: String): Country?
    suspend fun countryByPid(pid: String): Country?
    suspend fun addCountry(country: Country): Country?
    suspend fun updateCountry(updateCountry: UpdateCountry, pid: String): Country?
    suspend fun deleteCountry(pid: String): Boolean
}