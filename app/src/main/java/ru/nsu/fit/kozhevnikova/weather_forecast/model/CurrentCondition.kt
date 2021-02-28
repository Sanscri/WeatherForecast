package ru.nsu.fit.kozhevnikova.weather_forecast.model

class CurrentCondition (
    var pressure: Double,
    var humidity: Double
){
    override fun toString(): String {
        return "Давление: $pressure\n Влажность: $humidity"
    }
}