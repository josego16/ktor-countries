package domain.usecase

import domain.models.Country
import domain.repository.CountryInterface

class AllCountryUseCase(val repository: CountryInterface) {
    operator fun invoke(): List<Country> {
        return repository.allCountries()
    }
}