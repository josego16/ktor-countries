package domain.country.usecase

import domain.country.infra.Utils
import domain.country.repository.CountryInterface

class DeleteCountryUseCase(val repository: CountryInterface) {
    var pid: String? = null

    suspend operator fun invoke(): Boolean {
        return if (pid == null) {
            false
        } else {
            val country = repository.countryByPid(pid!!)
            country?.let { ctr ->
                ctr.flagUrl?.let { flag ->
                    Utils.deleteImage(ctr.pid, flag)
                    Utils.deleteDirectory(ctr.pid)
                }
                return repository.deleteCountry(pid!!)
            }
            false
        }
    }
}