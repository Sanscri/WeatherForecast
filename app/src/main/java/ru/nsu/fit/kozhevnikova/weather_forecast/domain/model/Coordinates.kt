package ru.nsu.fit.kozhevnikova.weather_forecast.domain.model

import com.google.gson.annotations.SerializedName


data class Coordinates(
    @SerializedName("lon")
    val longitude : Double,
    @SerializedName("lat")
    val latitude : Double
)
