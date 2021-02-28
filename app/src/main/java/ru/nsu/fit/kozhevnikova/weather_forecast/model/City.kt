package ru.nsu.fit.kozhevnikova.weather_forecast.model

data class City(
    val id: Long,
    val name: String,
    val latitude: String,
    val longitude: String,
    val countryCode: String
){
    override fun toString(): String {
        return "City: $name ($latitude, $longitude) ($countryCode)"
    }
}