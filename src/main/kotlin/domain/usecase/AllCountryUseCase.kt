package domain.usecase

import domain.models.country.Country
import domain.repository.CountryInterface

class AllCountryUseCase(val repository: CountryInterface) {
    suspend operator fun invoke(): List<Country> {
        return repository.allCountries()
    }
}