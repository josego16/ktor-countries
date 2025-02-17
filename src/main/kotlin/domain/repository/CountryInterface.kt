package domain.repository

import domain.models.Country
import domain.models.UpdateCountry
import domain.models.Language

interface CountryInterface {
    fun allCountries(): List<Country>
    fun countriesByLanguage(language: Language): List<Country>
    fun countryByName(name: String): Country?
    fun countryById(id: Int): Country?
    fun addCountry(country: Country): Boolean
    fun updateCountry(updateCountry: UpdateCountry, id: Int): Boolean
    fun deleteCountry(id: Int): Boolean
}