package domain.usecase

import domain.models.country.UpdateCountry
import domain.repository.CountryInterface

class UpdateCountryUseCase(val repository: CountryInterface) {
    var updateCountry: UpdateCountry? = null
    var pid: String? = null

    suspend operator fun invoke(): Boolean {
        return if (updateCountry == null || pid == null) {
            false
        } else {
            val result = repository.updateCountry(updateCountry!!, pid!!)
            result != null
        }
    }
}