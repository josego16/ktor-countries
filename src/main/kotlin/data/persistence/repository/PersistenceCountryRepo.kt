package data.persistence.repository

import data.persistence.models.country.CountryDao
import data.persistence.models.country.CountryTable
import data.persistence.models.suspendedTransaction
import domain.mapping.countryDaoToCountry
import domain.models.country.Country
import domain.models.country.UpdateCountry
import domain.models.enums.Language
import domain.repository.CountryInterface
import org.jetbrains.exposed.sql.deleteAll

class PersistenceCountryRepo : CountryInterface {
    override suspend fun allCountries(): List<Country> {
        return suspendedTransaction {
            CountryDao.all().map(::countryDaoToCountry)
        }
    }

    override suspend fun countriesByLanguage(language: Language): List<Country> {
        return suspendedTransaction {
            CountryDao.find {
                CountryTable.language eq language.toString()
            }.map(::countryDaoToCountry)
        }
    }

    override suspend fun countryByName(name: String): Country? {
        return suspendedTransaction {
            CountryDao.find {
                CountryTable.name eq name
            }.map(::countryDaoToCountry).firstOrNull()
        }
    }

    override suspend fun countryByPid(pid: String): Country? {
        return suspendedTransaction {
            CountryDao.find {
                CountryTable.pid eq pid
            }.limit(1).map(::countryDaoToCountry).firstOrNull()
        }
    }

    override suspend fun addCountry(country: Country): Country? {
        val coun = countryByPid(country.pid)
        return if (coun == null) {
            suspendedTransaction {
                CountryDao.new {
                    this.pid = country.pid
                    this.name = country.name
                    this.country = country.country
                    this.language = country.language.toString()
                    this.hostedOlympic = country.hostedOlympic.toString()
                    this.activeSport = country.activeSport.toString()
                    this.flagUrl = country.flagUrl
                }
            }
            coun
        } else {
            null
        }
    }

    override suspend fun updateCountry(country: UpdateCountry, pid: String): Country? {
        TODO()
    }

    override suspend fun deleteCountry(pid: String): Boolean = suspendedTransaction {
        val num = CountryTable.deleteAll()
        num == 1
    }
}