package data.persistence.models.country

import org.jetbrains.exposed.dao.id.IntIdTable

object CountryTable : IntIdTable("Country") {
    //val id = integer("id").autoIncrement()
    val pid = varchar("pid", 20).uniqueIndex()
    val name = varchar("name", 100)
    val country = varchar("country", 100)
    val language = varchar("language", 100)
    val hostedOlympic = varchar("hostedOlympic", 100)
    val activeSport = varchar("activeSport", 100)
    val flagUrl = varchar("flag_url", 255).nullable()
}