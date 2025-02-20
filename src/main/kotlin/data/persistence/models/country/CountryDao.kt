package data.persistence.models.country

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class CountryDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<CountryDao>(CountryTable)

    var pid by CountryTable.pid
    var name by CountryTable.name
    var country by CountryTable.country
    var language by CountryTable.language
    var hostedOlympic by CountryTable.hostedOlympic
    var activeSport by CountryTable.activeSport
    var flagUrl by CountryTable.flagUrl
}