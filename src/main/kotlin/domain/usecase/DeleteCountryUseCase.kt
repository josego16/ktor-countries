package domain.usecase

import domain.repository.CountryInterface

class DeleteCountryUseCase(val repository: CountryInterface) {
    var pid: String? = null

    suspend operator fun invoke(): Boolean {
        return if (pid == null) {
            false
        } else {
            return repository.deleteCountry(pid!!)
        }
    }
}