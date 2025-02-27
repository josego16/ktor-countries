package data.memory.country

import domain.country.models.country.Country
import domain.country.models.enums.Language

object CountriesData {
    val listCountry = mutableListOf(
        Country(
            "FR01",
            "France",
            "Paris",
            Language.French,
            "Tour de France",
            "Baguette",
            "https://flagcdn.com/w320/fr.png"
        ),
        Country(
            "US02",
            "United States",
            "Washington D.C.",
            Language.English,
            "Super Bowl",
            "Hamburger",
            "https://flagcdn.com/w320/us.png"
        ),
        Country(
            "JP03",
            "Japan",
            "Tokyo",
            Language.Japanese,
            "Cherry Blossom Festival",
            "Sushi",
            "https://flagcdn.com/w320/jp.png"
        ),
        Country(
            "DE04",
            "Germany",
            "Berlin",
            Language.German,
            "Oktoberfest",
            "Bratwurst",
            "https://flagcdn.com/w320/de.png"
        ),
        Country(
            "BR05",
            "Brazil",
            "Brasilia",
            Language.Portuguese,
            "Carnival of Rio",
            "Feijoada",
            "https://flagcdn.com/w320/br.png"
        ),
        Country(
            "KR06",
            "South Korea",
            "Seoul",
            Language.Korean,
            "Boryeong Mud Festival",
            "Kimchi",
            "https://flagcdn.com/w320/kr.png"
        ),
        Country(
            "CN07",
            "China",
            "Beijing",
            Language.Chinese,
            "Chinese New Year",
            "Peking Duck",
            "https://flagcdn.com/w320/cn.png"
        ),
        Country(
            "ES08",
            "Spain",
            "Madrid",
            Language.Spanish,
            "Running of the Bulls",
            "Paella",
            "https://flagcdn.com/w320/es.png"
        ),
        Country(
            "RU09",
            "Russia",
            "Moscow",
            Language.Russian,
            "Victory Day Parade",
            "Borscht",
            "https://flagcdn.com/w320/ru.png"
        ),
        Country(
            "IT10",
            "Italy",
            "Rome",
            Language.Italian,
            "Venice Carnival",
            "Pizza",
            "https://flagcdn.com/w320/it.png"
        ),
        Country(
            "UK11",
            "United Kingdom",
            "London",
            Language.English,
            "Wimbledon",
            "Fish and Chips",
            "https://flagcdn.com/w320/gb.png"
        ),
        Country(
            "AU12",
            "Australia",
            "Canberra",
            Language.English,
            "Melbourne Cup",
            "Vegemite",
            "https://flagcdn.com/w320/au.png"
        )
    )
}