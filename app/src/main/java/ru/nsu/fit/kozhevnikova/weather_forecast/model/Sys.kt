package ru.nsu.fit.kozhevnikova.weather_forecast.model

class Sys (
    var sunrise: Long,
    var sunset: Long
){
    override fun toString(): String {
        return "Восход солнца: $sunrise, Заход солнца: $sunset"
    }
}