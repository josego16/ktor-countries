package domain.country.usecase

import domain.country.models.country.Country
import domain.country.repository.CountryInterface

class CountryByPidUseCase(val repository: CountryInterface) {
    var pid: String? = null

    suspend operator fun invoke(): Country? {
        return if (pid?.isBlank() == true) {
            null
        } else {
            repository.countryByPid(pid!!)
        }
    }
}