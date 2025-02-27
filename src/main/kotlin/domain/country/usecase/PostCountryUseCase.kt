package domain.country.usecase

import domain.country.models.country.Country
import domain.country.repository.CountryInterface

class PostCountryUseCase(val repository: CountryInterface) {
    var country: Country? = null

    suspend operator fun invoke(): Boolean {
        return if (country == null) {
            false
        } else {
            repository.postCountry(country!!)
            true
        }
    }
}