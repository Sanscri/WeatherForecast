package ru.nsu.fit.kozhevnikova.weather_forecast.model

class CurrentWeather (
    var description: String,
    var idIcon: String
){
    override fun toString(): String {
        return "Описание: $description"
    }
}
