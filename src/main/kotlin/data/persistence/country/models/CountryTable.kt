package data.persistence.country.models

import org.jetbrains.exposed.dao.id.IntIdTable

object CountryTable : IntIdTable("Country") {
    var pid = varchar("pid", 20).uniqueIndex()
    val name = varchar("name", 100)
    val capital = varchar("capital", 100)
    val language = varchar("language", 100)
    val famousEvent = varchar("famousEvent", 100)
    val typicalGastronomy = varchar("typicalGastronomy", 100)
    val flagUrl = varchar("flag_url", 255).nullable()
}