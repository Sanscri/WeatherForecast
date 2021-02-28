package ru.nsu.fit.kozhevnikova.weather_forecast.model

data class Temperature(
    var temp: Double

    ){
    override fun toString(): String {
        return "Температура: $temp"
    }
}
