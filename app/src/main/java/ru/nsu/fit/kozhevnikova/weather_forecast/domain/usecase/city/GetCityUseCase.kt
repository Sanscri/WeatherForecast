package ru.nsu.fit.kozhevnikova.weather_forecast.domain.usecase.city

import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.City
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.repository.CityRepository

class GetCityUseCase(private val repository: CityRepository) {
    operator fun invoke(id: Long): City? = repository.getCity(id)
}