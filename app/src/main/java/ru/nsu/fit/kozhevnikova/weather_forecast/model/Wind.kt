package ru.nsu.fit.kozhevnikova.weather_forecast.model

data class Wind(
    var speed: Double,
    var direction: Double
){
    override fun toString(): String {
        return "Ветер: Скорость -$speed; Направление: $direction"
    }
}