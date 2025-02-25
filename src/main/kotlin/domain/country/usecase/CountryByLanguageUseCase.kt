package domain.country.usecase

import domain.country.models.country.Country
import domain.country.models.enums.Language
import domain.country.repository.CountryInterface

class CountryByLanguageUseCase(val repository: CountryInterface) {
    var language: Language? = null

    suspend operator fun invoke(): List<Country> {
        return language?.let {
            repository.countriesByLanguage(it)
        } ?: run {
            emptyList()
        }
    }
}