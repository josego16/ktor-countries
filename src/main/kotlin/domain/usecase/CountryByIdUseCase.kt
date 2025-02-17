package domain.usecase

import domain.models.Country
import domain.repository.CountryInterface

class CountryByIdUseCase(val repository: CountryInterface) {
    var id: Int? = null

    operator fun invoke(): Country? {
        return if (id == null) {
            null
        } else {
            repository.countryById(id!!)
        }
    }
}