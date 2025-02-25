package data.persistence.country.models

import data.persistence.country.models.CountryTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class CountryDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<CountryDao>(CountryTable)

    var pid by CountryTable.pid
    var name by CountryTable.name
    var capital by CountryTable.capital
    var language by CountryTable.language
    var famousEvent by CountryTable.famousEvent
    var typicalGastronomy by CountryTable.typicalGastronomy
    var flagUrl by CountryTable.flagUrl
}