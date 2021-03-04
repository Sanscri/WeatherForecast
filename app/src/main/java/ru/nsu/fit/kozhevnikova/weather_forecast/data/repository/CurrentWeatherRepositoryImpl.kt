package ru.nsu.fit.kozhevnikova.weather_forecast.data.repository

import ru.nsu.fit.kozhevnikova.weather_forecast.data.source.local.CurrentWeatherDataSource
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.*
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.repository.CurrentWeatherRepository

class CurrentWeatherRepositoryImpl(private val currentWeatherDataSource: CurrentWeatherDataSource): CurrentWeatherRepository{
    override fun getWeatherList(): List<CurrentWeather> = currentWeatherDataSource.getWeathers()

    override fun getCurrentWeather(id: Long): CurrentWeather? = currentWeatherDataSource.getWeather(id)

    override fun setCurrentWeather(currentWeather: CurrentWeather) {
        currentWeatherDataSource.setWeather(currentWeather)
    }

}