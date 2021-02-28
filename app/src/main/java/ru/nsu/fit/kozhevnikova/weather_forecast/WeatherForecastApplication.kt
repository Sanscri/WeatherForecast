package ru.nsu.fit.kozhevnikova.weather_forecast

import android.app.Application
import ru.nsu.fit.kozhevnikova.weather_forecast.repository.CityRepository
import ru.nsu.fit.kozhevnikova.weather_forecast.repository.WeatherForecastRepository

class WeatherForecastApplication: Application() {
    lateinit var cityRepository: CityRepository
    lateinit var weatherForecastRepository: WeatherForecastRepository
    override fun onCreate(){
        super.onCreate()
        cityRepository = CityRepository()
        weatherForecastRepository = WeatherForecastRepository()
    }
}