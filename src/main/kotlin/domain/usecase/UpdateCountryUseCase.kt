package domain.usecase

import domain.models.country.UpdateCountry
import domain.repository.CountryInterface

class UpdateCountryUseCase(val repository: CountryInterface) {
    var updateCountry: UpdateCountry? = null
    var id: Int? = null

    operator fun invoke(): Boolean {
        return if (updateCountry == null || id == null) {
            false
        } else {
            val result = repository.updateCountry(updateCountry!!, id!!)
            result != null
        }
    }
}