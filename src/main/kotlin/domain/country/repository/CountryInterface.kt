package domain.country.repository

import domain.country.models.country.Country
import domain.country.models.country.UpdateCountry
import domain.country.models.enums.Language

interface CountryInterface {
    suspend fun allCountries(): List<Country>
    suspend fun countryByPid(pid: String): Country?
    suspend fun countryByName(name: String): Country?
    suspend fun countriesByLanguage(language: Language): List<Country>
    suspend fun postCountry(country: Country): Country?
    suspend fun updateCountry(updateCountry: UpdateCountry, pid: String): Country?
    suspend fun deleteCountry(pid: String): Boolean
}