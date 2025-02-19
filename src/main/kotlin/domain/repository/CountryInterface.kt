package domain.repository

import domain.models.country.Country
import domain.models.country.UpdateCountry
import domain.models.enums.Language

interface CountryInterface {
    fun allCountries(): List<Country>
    fun countriesByLanguage(language: Language): List<Country>
    fun countryByName(name: String): Country?
    fun countryById(id: Int): Country?
    fun addCountry(country: Country): Country?
    fun updateCountry(updateCountry: UpdateCountry, id: Int): Country?
    fun deleteCountry(id: Int): Boolean
}