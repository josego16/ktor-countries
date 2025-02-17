package domain.usecase

import domain.models.Country
import domain.repository.CountryInterface

class AddCountryUseCase(val repository: CountryInterface) {
    var country: Country? = null
    operator fun invoke(): Boolean {
        //Si devuelve null, es que ya existe el empleado
        return if (country == null) {
            false
        } else {
            repository.addCountry(country!!)
        }
    }
}