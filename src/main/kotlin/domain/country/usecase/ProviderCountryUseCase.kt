package domain.country.usecase

import data.persistence.country.repository.PersistenceCountryRepo
import domain.country.models.country.Country
import domain.country.models.country.UpdateCountry
import domain.country.models.enums.Language
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object ProviderCountryUseCase {
    private val repoCountry = PersistenceCountryRepo()
    val logger: Logger = LoggerFactory.getLogger("CountryUseCaseLogger")

    private val allCountryUseCase = AllCountryUseCase(repoCountry)
    private val countryByPidUseCase = CountryByPidUseCase(repoCountry)
    private val countryByLanguageUseCase = CountryByLanguageUseCase(repoCountry)
    private val postCountryUseCase = PostCountryUseCase(repoCountry)
    private val deleteCountryUseCase = DeleteCountryUseCase(repoCountry)
    private val updateCountryUseCase = UpdateCountryUseCase(repoCountry)

    suspend fun allCountries() = allCountryUseCase()
    suspend fun countryById(pid: String): Country? {
        if (pid.isBlank()) {
            logger.warn("Pid is null or empty")
            return null
        }
        countryByPidUseCase.pid = pid
        val country = countryByPidUseCase()
        return if (country == null) {
            logger.warn("No se ha encontrado un país con el ID: $pid")
            null
        } else {
            return country
        }
    }

    suspend fun countryByLanguage(language: Language): List<Country> {
        countryByLanguageUseCase.language = language
        return countryByLanguageUseCase()
    }

    suspend fun addCountry(country: Country?): Boolean {
        if (country == null) {
            logger.warn("No existen datos del pais a insertar")
            return false
        }
        postCountryUseCase.country = country
        val res = postCountryUseCase()
        return if (!res) {
            logger.warn("No se ha insertado el empleado. Posiblemente ya exista")
            false
        } else {
            true
        }
    }

    suspend fun updateCountry(updateCountry: UpdateCountry?, pid: String): Boolean {
        if (updateCountry == null) {
            logger.warn("No existen datos del pais para actualizar")
            return false
        }
        updateCountryUseCase.updateCountry = updateCountry
        updateCountryUseCase.pid = pid
        return updateCountryUseCase()
    }

    suspend fun deleteCountry(pid: String): Boolean {
        deleteCountryUseCase.pid = pid
        return deleteCountryUseCase()
    }
}