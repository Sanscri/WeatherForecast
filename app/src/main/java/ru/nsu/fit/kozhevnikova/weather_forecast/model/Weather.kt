package ru.nsu.fit.kozhevnikova.weather_forecast.model

data class Weather(
    val city: City,
    var temperature: Temperature,
    var wind: Wind,
    var currentWeather: CurrentWeather,
    var currentCondition: CurrentCondition,
    var cloud: Cloud,
    var sys: Sys
){
    override fun toString(): String {
        return city.toString() + temperature.toString() + wind.toString() +
        currentWeather.toString() + currentCondition.toString() +
        cloud.toString() + sys.toString()
    }
}