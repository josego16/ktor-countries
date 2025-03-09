package domain.country.usecase

import domain.country.models.country.Country
import domain.country.models.enums.Language
import domain.country.repository.CountryInterface
import ktor.ApplicationContext

class CountryByLanguageUseCase(val repository: CountryInterface) {
    var language: Language? = null

    suspend operator fun invoke(): List<Country> {
        return language?.let {
            val list = repository.countriesByLanguage(it)
            list.map { ctr ->
                if (!ctr.flagUrl.isNullOrBlank()) {
                    val local = ApplicationContext.context.environment.config.property("ktor.urlPath.baseUrl").getString()
                    val relativePath = ApplicationContext.context.environment.config.property("ktor.urlPath.images").getString()
                    ctr.flagUrl = "$local/$relativePath/${ctr.pid}/${ctr.flagUrl}"
                }
                ctr
            }
        } ?: run {
            emptyList()
        }
    }
}