package data.memory.models

import domain.models.country.Country
import domain.models.enums.Language
import domain.models.enums.OlympicEvent
import domain.models.enums.Sport

object CountriesData {
    val listCountry = mutableListOf(
        Country(
            pid = "FR01",
            name = "France",
            country = "France",
            language = Language.FRENCH,
            hostedOlympic = listOf(OlympicEvent.PARIS_2024),
            activeSport = listOf(Sport.FOOTBALL, Sport.JUDO, Sport.CYCLING, Sport.SWIMMING),
            flagUrl = "https://flagcdn.com/w320/fr.png"
        ),
        Country(
            pid = "EEUU02",
            name = "United States",
            country = "USA",
            language = Language.ENGLISH,
            hostedOlympic = listOf(OlympicEvent.ATLANTA_1996, OlympicEvent.SALT_LAKE_CITY_2002),
            activeSport = listOf(Sport.BASKETBALL, Sport.ATHLETICS, Sport.SWIMMING, Sport.GYMNASTICS),
            flagUrl = "https://flagcdn.com/w320/us.png"
        ),
        Country(
            pid = "JP03",
            name = "Japan",
            country = "Japan",
            language = Language.JAPANESE,
            hostedOlympic = listOf(OlympicEvent.TOKYO_2020, OlympicEvent.NAGANO_1998),
            activeSport = listOf(Sport.JUDO, Sport.TABLE_TENNIS, Sport.WRESTLING, Sport.TAEKWONDO),
            flagUrl = "https://flagcdn.com/w320/jp.png"
        ),
        Country(
            pid = "GR04",
            name = "Germany",
            country = "Germany",
            language = Language.GERMAN,
            hostedOlympic = listOf(OlympicEvent.MUNICH_1972),
            activeSport = listOf(Sport.FENCING, Sport.ROWING, Sport.CYCLING, Sport.HANDBALL),
            flagUrl = "https://flagcdn.com/w320/de.png"
        ),
        Country(
            pid = "BR05",
            name = "Brazil",
            country = "Brazil",
            language = Language.PORTUGUESE,
            hostedOlympic = listOf(OlympicEvent.RIO_2016),
            activeSport = listOf(Sport.FOOTBALL, Sport.VOLLEYBALL, Sport.JUDO, Sport.SWIMMING),
            flagUrl = "https://flagcdn.com/w320/br.png"
        ),
        Country(
            pid = "KR06",
            name = "South Korea",
            country = "South Korea",
            language = Language.KOREAN,
            hostedOlympic = listOf(OlympicEvent.SEOUL_1988, OlympicEvent.PYEONGCHANG_2018),
            activeSport = listOf(Sport.TAEKWONDO, Sport.ARCHERY, Sport.SHOOTING, Sport.WEIGHTLIFTING),
            flagUrl = "https://flagcdn.com/w320/kr.png"
        ),
        Country(
            pid = "CN07",
            name = "China",
            country = "China",
            language = Language.CHINESE,
            hostedOlympic = listOf(OlympicEvent.BEIJING_2008, OlympicEvent.BEIJING_2022),
            activeSport = listOf(Sport.TABLE_TENNIS, Sport.WEIGHTLIFTING, Sport.BADMINTON, Sport.SHOOTING),
            flagUrl = "https://flagcdn.com/w320/cn.png"
        ),
        Country(
            pid = "ES08",
            name = "Spain",
            country = "Spain",
            language = Language.SPANISH,
            hostedOlympic = listOf(OlympicEvent.BARCELONA_1992),
            activeSport = listOf(Sport.FOOTBALL, Sport.BASKETBALL, Sport.TENNIS, Sport.CYCLING),
            flagUrl = "https://flagcdn.com/w320/es.png"
        ),
        Country(
            pid = "CIS09",
            name = "Russia",
            country = "Russia",
            language = Language.RUSSIAN,
            hostedOlympic = listOf(OlympicEvent.SOCHI_2014),
            activeSport = listOf(Sport.WRESTLING, Sport.WEIGHTLIFTING, Sport.ATHLETICS, Sport.SHOOTING),
            flagUrl = "https://flagcdn.com/w320/ru.png"
        ),
        Country(
            pid = "IT10",
            name = "Italy",
            country = "Italy",
            language = Language.ITALIAN,
            hostedOlympic = listOf(OlympicEvent.TURIN_2006, OlympicEvent.MILAN_CORTINA_2026),
            activeSport = listOf(Sport.FENCING, Sport.ROWING, Sport.CYCLING, Sport.ATHLETICS),
            flagUrl = "https://flagcdn.com/w320/it.png"
        ),
        Country(
            pid = "UK11",
            name = "United Kingdom",
            country = "United Kingdom",
            language = Language.ENGLISH,
            hostedOlympic = listOf(OlympicEvent.LONDON_2012),
            activeSport = listOf(Sport.CYCLING, Sport.ATHLETICS, Sport.ROWING, Sport.BOXING),
            flagUrl = "https://flagcdn.com/w320/gb.png"
        ),
        Country(
            pid = "AU02",
            name = "Australia",
            country = "Australia",
            language = Language.ENGLISH,
            hostedOlympic = listOf(OlympicEvent.SYDNEY_2000),
            activeSport = listOf(Sport.SWIMMING, Sport.CYCLING, Sport.ATHLETICS, Sport.ROWING),
            flagUrl = "https://flagcdn.com/w320/au.png"
        )
    )
}