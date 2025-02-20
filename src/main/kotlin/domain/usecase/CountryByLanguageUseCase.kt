package domain.usecase

import domain.models.country.Country
import domain.models.enums.Language
import domain.repository.CountryInterface

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