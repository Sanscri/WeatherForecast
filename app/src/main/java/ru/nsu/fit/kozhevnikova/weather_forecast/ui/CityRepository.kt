package ru.nsu.fit.kozhevnikova.weather_forecast.ui

class CityRepository {
    private val cities = mutableListOf(
        City(id = 0, name = "Conor"),
        City(id = 1, name = "John"),
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