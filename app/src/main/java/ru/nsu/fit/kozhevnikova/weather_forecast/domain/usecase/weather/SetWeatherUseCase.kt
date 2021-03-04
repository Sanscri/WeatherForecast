package ru.nsu.fit.kozhevnikova.weather_forecast.domain.usecase.weather

import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.City
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.CurrentWeather
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.repository.CurrentWeatherRepository

class SetWeatherUseCase(private val repository: CurrentWeatherRepository) {
    operator fun invoke(currentWeather: CurrentWeather){
        repository.setCurrentWeather(currentWeather)
    }
}