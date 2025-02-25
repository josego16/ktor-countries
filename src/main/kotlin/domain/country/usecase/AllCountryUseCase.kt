package domain.country.usecase

import domain.country.models.country.Country
import domain.country.repository.CountryInterface

class AllCountryUseCase(val repository: CountryInterface) {
    suspend operator fun invoke(): List<Country> {
        return repository.allCountries()
    }
}