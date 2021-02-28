package ru.nsu.fit.kozhevnikova.weather_forecast.repository

import ru.nsu.fit.kozhevnikova.weather_forecast.model.City

class CityRepository {
    private val cities = mutableListOf(
        City(id = 0, name = "Moscow", latitude = "12.34", longitude = "133.24", countryCode = "RU"),
        City(id = 1, name = "Novosibirsk", latitude = "12.34", longitude = "12.24", countryCode = "RU"),
        City(id = 2, name = "London", latitude = "12.34", longitude = "12.24", countryCode = "UK"),
        City(id = 3, name = "New York", latitude = "12.34", longitude = "12.24", countryCode = "US"),
        City(id = 4, name = "Paris", latitude = "12.34", longitude = "12.24", countryCode = "FR"),
    )

    fun getCities(): List<City> = cities

    fun getCity(id: Long): City? = cities.firstOrNull { it.id == id }

    fun setCity(city: City) {
        val editCityIndex = cities.indexOfFirst { it.id == city.id }
        if (editCityIndex >= 0) {
            cities[editCityIndex] = city
        }
    }
}