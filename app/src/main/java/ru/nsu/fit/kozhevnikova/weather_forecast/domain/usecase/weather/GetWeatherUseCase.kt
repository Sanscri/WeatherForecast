package ru.nsu.fit.kozhevnikova.weather_forecast.domain.usecase.weather

import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.CurrentWeather
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.repository.CurrentWeatherRepository

class GetWeatherUseCase(private val repository: CurrentWeatherRepository) {
    operator fun invoke(id: Long): CurrentWeather? = repository.getCurrentWeather(id)
}