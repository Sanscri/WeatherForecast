package ru.nsu.fit.kozhevnikova.weather_forecast

import android.app.Application
import ru.nsu.fit.kozhevnikova.weather_forecast.data.repository.CityRepositoryImpl
import ru.nsu.fit.kozhevnikova.weather_forecast.data.repository.WeatherForecastRepositoryImpl

class WeatherForecastApplication: Application() {
    lateinit var cityRepositoryImpl: CityRepositoryImpl
    lateinit var weatherForecastRepositoryImpl: WeatherForecastRepositoryImpl
    override fun onCreate(){
        super.onCreate()
        cityRepositoryImpl = CityRepositoryImpl()
        weatherForecastRepositoryImpl = WeatherForecastRepositoryImpl()
    }
}