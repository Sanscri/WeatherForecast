package ru.nsu.fit.kozhevnikova.weather_forecast.model

data class Cloud(
    var clouds: Int
){
    override fun toString(): String {
        return "Облачность: $clouds"
    }
}