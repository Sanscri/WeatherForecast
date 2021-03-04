package ru.nsu.fit.kozhevnikova.weather_forecast.data.repository

import ru.nsu.fit.kozhevnikova.weather_forecast.data.source.local.CityDataSource
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.City
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.Coordinates
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.repository.CityRepository

class CityRepositoryImpl(private val cityDataSource: CityDataSource): CityRepository {
    override fun getCities(): List<City> {
        return cityDataSource.getCities()
    }

    override fun getCity(id: Long): City? {
        return cityDataSource.getCity(id)
    }

    override fun setCity(city: City) {
        cityDataSource.setCity(city)
    }
}