package ru.nsu.fit.kozhevnikova.weather_forecast.data.source.local

import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.City

interface CityDataSource {
    fun getCities(): List<City>
    fun getCity(id: Long): City?
    fun setCity(city: City)
}