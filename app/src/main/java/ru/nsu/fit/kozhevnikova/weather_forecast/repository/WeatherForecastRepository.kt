package ru.nsu.fit.kozhevnikova.weather_forecast.repository

import androidx.lifecycle.LiveData
import ru.nsu.fit.kozhevnikova.weather_forecast.model.*

class WeatherForecastRepository {
    private val allWeather = mutableListOf(
        Weather(
            City(id = 0, name = "Moscow", latitude = "12.34", longitude = "133.24", countryCode = "RU"),
            Temperature(14.3),
            Wind(12.3, 17.5),
            CurrentWeather("description","icon"),
            CurrentCondition(15.2, 13.4),
            Cloud(11),
            Sys(14, 14)
        ),
        Weather(
            City(id = 1, name = "Novosibirsk", latitude = "12.34", longitude = "12.24", countryCode = "RU"),
            Temperature(14.3),
            Wind(12.3, 17.5),
            CurrentWeather("description","icon"),
            CurrentCondition(15.2, 13.4),
            Cloud(11),
            Sys(14, 14)
        ),
        Weather(
            City(id = 2, name = "London", latitude = "12.34", longitude = "12.24", countryCode = "UK"),
            Temperature(14.3),
            Wind(12.3, 17.5),
            CurrentWeather("description","icon"),
            CurrentCondition(15.2, 13.4),
            Cloud(11),
            Sys(14, 14)
        ),
        Weather(
            City(id = 3, name = "New York", latitude = "12.34", longitude = "12.24", countryCode = "US"),
            Temperature(14.3),
            Wind(12.3, 17.5),
            CurrentWeather("description","icon"),
            CurrentCondition(15.2, 13.4),
            Cloud(11),
            Sys(14, 14)
        ),
        Weather(
            City(id = 4, name = "Paris", latitude = "12.34", longitude = "12.24", countryCode = "FR"),
            Temperature(14.3),
            Wind(12.3, 17.5),
            CurrentWeather("description","icon"),
            CurrentCondition(15.2, 13.4),
            Cloud(11),
            Sys(14, 14)
        ),
    )


    fun getWeather(id: Long): Weather? = allWeather.firstOrNull { it.city.id == id }

    fun setWeather(weather: Weather) {
        val editCityIndex = allWeather.indexOfFirst { it.city.id == weather.city.id }
        if (editCityIndex >= 0) {
            allWeather[editCityIndex] = weather
        }
    }
}