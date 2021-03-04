package ru.nsu.fit.kozhevnikova.weather_forecast.data.source.local

import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.CurrentWeather

interface CurrentWeatherDataSource {
    fun getWeathers(): List<CurrentWeather>
    fun getWeather(id: Long): CurrentWeather?
    fun setWeather(currentWeather: CurrentWeather)
}