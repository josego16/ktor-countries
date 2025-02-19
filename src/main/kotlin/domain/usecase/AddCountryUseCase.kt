package domain.usecase

import domain.models.country.Country
import domain.repository.CountryInterface

class AddCountryUseCase(val repository: CountryInterface) {
    var country: Country? = null

    operator fun invoke(): Boolean {
        return country?.let {
            repository.addCountry(it) != null
        } == true
    }
}