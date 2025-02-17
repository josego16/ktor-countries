package domain.usecase

import domain.repository.CountryInterface

class DeleteCountryUseCase(val repository: CountryInterface) {
    var id: Int? = null

    operator fun invoke(): Boolean {
        return if (id == null) {
            false
        } else {
            return repository.deleteCountry(id!!)
        }
    }
}