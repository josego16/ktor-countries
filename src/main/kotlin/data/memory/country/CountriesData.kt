package data.memory.country

import domain.country.models.country.Country
import domain.country.models.enums.Events
import domain.country.models.enums.Gastronomy
import domain.country.models.enums.Language

object CountriesData {
    val listCountry = mutableListOf(
        Country(
            "FR01",
            "France",
            "Paris",
            Language.FRENCH,
            Events.TOUR_DE_FRANCE,
            Gastronomy.BAGUETTE,
            "https://flagcdn.com/w320/fr.png"
        ),
        Country(
            "US02",
            "United States",
            "Washington D.C.",
            Language.ENGLISH,
            Events.SUPER_BOWL,
            Gastronomy.HAMBURGER,
            "https://flagcdn.com/w320/us.png"
        ),
        Country(
            "JP03",
            "Japan",
            "Tokyo",
            Language.JAPANESE,
            Events.CHERRY_BLOSSOM_FESTIVAL,
            Gastronomy.SUSHI,
            "https://flagcdn.com/w320/jp.png"
        ),
        Country(
            "DE04",
            "Germany",
            "Berlin",
            Language.GERMAN,
            Events.OKTOBERFEST,
            Gastronomy.BRATWURST,
            "https://flagcdn.com/w320/de.png"
        ),
        Country(
            "BR05",
            "Brazil",
            "Brasilia",
            Language.PORTUGUESE,
            Events.CARNIVAL_OF_RIO,
            Gastronomy.FEIJOADA,
            "https://flagcdn.com/w320/br.png"
        ),
        Country(
            "KR06",
            "South Korea",
            "Seoul",
            Language.KOREAN,
            Events.BORYEONG_MUD_FESTIVAL,
            Gastronomy.KIMCHI,
            "https://flagcdn.com/w320/kr.png"
        ),
        Country(
            "CN07",
            "China",
            "Beijing",
            Language.CHINESE,
            Events.CHINESE_NEW_YEAR,
            Gastronomy.PEKING_DUCK,
            "https://flagcdn.com/w320/cn.png"
        ),
        Country(
            "ES08",
            "Spain",
            "Madrid",
            Language.SPANISH,
            Events.RUNNING_OF_THE_BULLS,
            Gastronomy.PAELLA,
            "https://flagcdn.com/w320/es.png"
        ),
        Country(
            "RU09",
            "Russia",
            "Moscow",
            Language.RUSSIAN,
            Events.VICTORY_DAY_PARADE,
            Gastronomy.BORSCHT,
            "https://flagcdn.com/w320/ru.png"
        ),
        Country(
            "IT10",
            "Italy",
            "Rome",
            Language.ITALIAN,
            Events.VENICE_CARNIVAL,
            Gastronomy.PIZZA,
            "https://flagcdn.com/w320/it.png"
        ),
        Country(
            "UK11",
            "United Kingdom",
            "London",
            Language.ENGLISH,
            Events.WIMBLEDON,
            Gastronomy.FISH_AND_CHIPS,
            "https://flagcdn.com/w320/gb.png"
        ),
        Country(
            "AU12",
            "Australia",
            "Canberra",
            Language.ENGLISH,
            Events.MELBOURNE_CUP,
            Gastronomy.VEGEMITE,
            "https://flagcdn.com/w320/au.png"
        )
    )
}