package ru.nsu.fit.kozhevnikova.weather_forecast

import android.app.Application
import ru.nsu.fit.kozhevnikova.weather_forecast.data.repository.CityRepositoryImpl
import ru.nsu.fit.kozhevnikova.weather_forecast.data.repository.CurrentWeatherRepositoryImpl

class WeatherForecastApplication: Application() {
    override fun onCreate(){
        super.onCreate()
    }
}