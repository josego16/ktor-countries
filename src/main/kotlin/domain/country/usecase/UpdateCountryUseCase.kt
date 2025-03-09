package domain.country.usecase

import domain.country.infra.Utils
import domain.country.models.country.Country
import domain.country.models.country.UpdateCountry
import domain.country.repository.CountryInterface

class UpdateCountryUseCase(val repository: CountryInterface) {
    var updateCountry: UpdateCountry? = null
    var pid: String? = null

    suspend operator fun invoke(): Country? {
        return if (updateCountry == null || pid == null) {
            null
        } else {
            try {
                updateCountry?.flagUrl?.let { newImg ->
                    val country = repository.countryByPid(pid!!)
                    country?.let { ctr ->
                        ctr.flagUrl?.let { oldImg ->
                            Utils.deleteImage(ctr.pid, oldImg)
                        }
                    }
                    val newImgUrl = Utils.createBase64ToImg(newImg, pid!!)
                    updateCountry!!.flagUrl = newImgUrl
                }
                val country = repository.updateCountry(updateCountry!!, pid!!)
                country
            } catch (error: Exception) {
                error.localizedMessage
                null
            }
        }
    }
}