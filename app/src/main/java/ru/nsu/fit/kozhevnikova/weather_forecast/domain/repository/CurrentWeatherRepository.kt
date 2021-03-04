package ru.nsu.fit.kozhevnikova.weather_forecast.domain.repository

import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.CurrentWeather

interface CurrentWeatherRepository {
    fun getWeatherList(): List<CurrentWeather>
    fun getCurrentWeather(id: Long): CurrentWeather?
    fun setCurrentWeather(currentWeather: CurrentWeather)
}