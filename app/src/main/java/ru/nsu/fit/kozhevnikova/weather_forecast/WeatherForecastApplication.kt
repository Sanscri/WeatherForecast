package ru.nsu.fit.kozhevnikova.weather_forecast

import android.app.Application
import ru.nsu.fit.kozhevnikova.weather_forecast.ui.CityRepository

class WeatherForecastApplication: Application() {
    lateinit var cityRepository: CityRepository
    override fun onCreate(){
        super.onCreate()
        cityRepository = CityRepository()
    }
}