package domain.usecase

import data.repository.MemoryOlympicRepo
import domain.models.Country
import domain.models.UpdateCountry
import domain.models.enums.Language
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object ProviderUseCase {
    private val repository = MemoryOlympicRepo()
    val logger: Logger = LoggerFactory.getLogger("CountryUseCaseLogger")

    private val allCountryUseCase = AllCountryUseCase(repository)
    private val countryByIdUseCase = CountryByIdUseCase(repository)
    private val countryByLanguageUseCase = CountryByLanguageUseCase(repository)
    private val addCountryUseCase = AddCountryUseCase(repository)
    private val deleteCountryUseCase = DeleteCountryUseCase(repository)
    private val updateCountryUseCase = UpdateCountryUseCase(repository)

    fun allCountries() = allCountryUseCase
    fun countryById(id: Int): Country? {
        countryByIdUseCase.id = id
        val country = countryByIdUseCase()
        if (country == null) {
            logger.warn("No se ha encontrado un país con el ID: $id")
        }
        return country
    }

    fun countryByLanguage(language: Language): List<Country> {
        countryByLanguageUseCase.language = language
        return countryByLanguageUseCase()
    }

    fun addCountry(country: Country?): Boolean {
        if (country == null) {
            logger.warn("No existen datos del pais a insertar")
            return false
        }
        addCountryUseCase.country = country
        val res = addCountryUseCase()
        return if (!res) {
            logger.warn("No se ha insertado el empleado. Posiblemente ya exista")
            false
        } else {
            true
        }
    }

    fun updateCountry(updateCountry: UpdateCountry?, id: Int): Boolean {
        if (updateCountry == null) {
            logger.warn("No existen datos del pais para actualizar")
            return false
        }
        updateCountryUseCase.updateCountry = updateCountry
        updateCountryUseCase.id = id
        return updateCountryUseCase()
    }

    fun deleteCountry(id: Int): Boolean {
        deleteCountryUseCase.id = id
        return deleteCountryUseCase()
    }
}