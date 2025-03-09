package domain.country.usecase

import domain.country.infra.Utils
import domain.country.models.country.Country
import domain.country.repository.CountryInterface
import ktor.ApplicationContext

class PostCountryUseCase(val repository: CountryInterface) {
    var country: Country? = null

    suspend operator fun invoke(): Country? {
        val ctr = repository.countryByPid(country!!.pid)
        return if (ctr != null) {
            null
        } else {
            val isCreateDir = Utils.createDir(country!!.pid)
            if (isCreateDir) {
                val img = country!!.flagUrl
                if (!img.isNullOrBlank()) {
                    country!!.flagUrl = Utils.createBase64ToImg(
                        img,
                        country!!.pid
                    )
                }
            } else {
                throw IllegalStateException("No se pudo crear el directorio del pais. Puede que ya exista")
            }

            val new = repository.postCountry(country!!)

            new?.let { coun ->
                if (!coun.flagUrl.isNullOrBlank()) {
                    val local = ApplicationContext.context.environment.config.property("ktor.urlPath.baseUrl").getString()
                    val relativePath = ApplicationContext.context.environment.config.property("ktor.urlPath.images").getString()
                    new.flagUrl = "$local/$relativePath/${new.pid}/${coun.flagUrl}"
                }
            }

            return new
        }
    }
}