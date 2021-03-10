package ru.nsu.fit.kozhevnikova.weather_forecast.domain.repository

import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.City

interface CityRepository {
    fun getCities(): List<City>
    fun getCity(id: Long): City?
    fun setCity(city: City)
}