package domain.country.usecase

import domain.country.models.country.Country
import domain.country.repository.CountryInterface
import ktor.ApplicationContext

class CountryByPidUseCase(val repository: CountryInterface) {
    var pid: String? = null

    suspend operator fun invoke(): Country? {
        return if (pid?.isBlank() == true) {
            null
        } else {
            val country = repository.countryByPid(pid!!)
            country?.let { ctr ->
                if (!ctr.flagUrl.isNullOrBlank()) {
                    val local = ApplicationContext.context.environment.config.property("ktor.urlPath.baseUrl").getString()
                    val relativePath = ApplicationContext.context.environment.config.property("ktor.urlPath.images").getString()
                    country.flagUrl = "$local/$relativePath/${pid}/${ctr.flagUrl}"
                }
            }
            return country
        }
    }
}