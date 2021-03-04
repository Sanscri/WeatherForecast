package ru.nsu.fit.kozhevnikova.weather_forecast.domain.model

import com.google.gson.annotations.SerializedName

data class Snow(
    @SerializedName("3h")
    val snowVolume : Double
)