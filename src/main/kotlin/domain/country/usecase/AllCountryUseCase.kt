package domain.country.usecase

import domain.country.models.country.Country
import domain.country.repository.CountryInterface
import ktor.ApplicationContext

class AllCountryUseCase(val repository: CountryInterface) {
    suspend operator fun invoke(): List<Country> {
        val listCountry = repository.allCountries()
        return listCountry.map { ctr ->
            if (!ctr.flagUrl.isNullOrBlank()) {
                val local = ApplicationContext.context.environment.config.property("ktor.urlPath.baseUrl").getString()
                val relativePath = ApplicationContext.context.environment.config.property("ktor.urlPath.images").getString()
                ctr.flagUrl = "$local/$relativePath/${ctr.pid}/${ctr.flagUrl}"
            }
            ctr
        }
    }
}