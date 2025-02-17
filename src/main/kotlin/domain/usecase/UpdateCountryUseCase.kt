package domain.usecase

import domain.models.UpdateCountry
import domain.repository.CountryInterface

class UpdateCountryUseCase(val repository: CountryInterface) {
    var updateCountry: UpdateCountry? = null
    var id: Int? = null

    operator fun invoke(): Boolean {
        return if (updateCountry == null || id == null) {
            false
        } else {
            return repository.updateCountry(updateCountry!!, id!!)
        }
    }
}