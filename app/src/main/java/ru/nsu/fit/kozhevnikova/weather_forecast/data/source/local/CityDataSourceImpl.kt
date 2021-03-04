package ru.nsu.fit.kozhevnikova.weather_forecast.data.source.local

import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.City
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.Coordinates

class CityDataSourceImpl: CityDataSource {
    private val cities = mutableListOf(
        City(id = 0, name = "Moscow", Coordinates(latitude = 12.34, longitude = 133.24), country = "RU"),
        City(id = 1, name = "Novosibirsk", Coordinates(latitude = 12.34, longitude = 133.24), country = "RU"),
        City(id = 2, name = "London", Coordinates(latitude = 12.34, longitude = 133.24), country = "UK"),
        City(id = 3, name = "New York", Coordinates(latitude = 12.34, longitude = 133.24), country = "US"),
        City(id = 4, name = "Paris", Coordinates(latitude = 12.34, longitude = 133.24), country = "FR"),
    )

    override fun getCities(): List<City> = cities

    override fun getCity(id: Long): City? = cities.firstOrNull { it.id == id }

    override fun setCity(city: City) {
        val editCityIndex = cities.indexOfFirst { it.id == city.id }
        if (editCityIndex >= 0) {
            cities[editCityIndex] = city
        }
    }
}