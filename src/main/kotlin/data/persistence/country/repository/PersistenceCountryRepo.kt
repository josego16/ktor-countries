package data.persistence.country.repository

import data.persistence.country.models.CountryDao
import data.persistence.country.models.CountryTable
import data.persistence.suspendedTransaction
import domain.country.mapping.toCountry
import domain.country.models.country.Country
import domain.country.models.country.UpdateCountry
import domain.country.models.enums.Language
import domain.country.repository.CountryInterface
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.update

class PersistenceCountryRepo : CountryInterface {
    override suspend fun allCountries(): List<Country> {
        return suspendedTransaction {
            CountryDao.all().map { it.toCountry() }
        }
    }

    override suspend fun countryByPid(pid: String): Country? {
        return suspendedTransaction {
            CountryDao.find {
                CountryTable.pid eq pid
            }.limit(1).map { it.toCountry() }.firstOrNull()
        }
    }

    override suspend fun countryByName(name: String): Country? {
        return suspendedTransaction {
            CountryDao.find {
                CountryTable.name eq name
            }.map { it.toCountry() }.firstOrNull()
        }
    }

    override suspend fun countriesByLanguage(language: Language): List<Country> {
        return suspendedTransaction {
            CountryDao.find {
                CountryTable.language eq language.toString()
            }.map { it.toCountry() }
        }
    }

    override suspend fun postCountry(country: Country): Country? {
        val coun = countryByPid(country.pid)
        return if (coun == null) {
            suspendedTransaction {
                CountryDao.new {
                    this.pid = country.pid
                    this.name = country.name
                    this.capital = country.capital
                    this.language = country.language.toString()
                    this.famousEvent = country.famousEvent
                    this.typicalGastronomy = country.typicalGastronomy
                    this.flagUrl = country.flagUrl
                }
            }
            country
        } else {
            null
        }
    }

    override suspend fun updateCountry(updateCountry: UpdateCountry, pid: String): Country? {
        var num = 0
        try {
            suspendedTransaction {
                num = CountryTable.update({ CountryTable.pid eq pid }) { stm ->
                    updateCountry.name?.let { stm[name] = it }
                    updateCountry.capital?.let { stm[capital] = it }
                    updateCountry.language?.let { stm[language] = it.toString() }
                    updateCountry.famousEvent?.let { stm[famousEvent] = it }
                    updateCountry.typicalGastronomy?.let { stm[typicalGastronomy] = it }
                    updateCountry.flagUrl?.let { stm[flagUrl] = it }
                }
            }
        } catch (error: Exception) {
            println("Error al actualizar un pais ${error.localizedMessage}")
        }
        return if (num == 1) countryByPid(pid) else null
    }

    override suspend fun deleteCountry(pid: String): Boolean = suspendedTransaction {
        val num = CountryTable.deleteWhere { CountryTable.pid eq pid }
        num == 1
    }
}