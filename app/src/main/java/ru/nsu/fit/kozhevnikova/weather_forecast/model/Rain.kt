package ru.nsu.fit.kozhevnikova.weather_forecast.model

import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("3h")
    val rainVolume : Double
)