package ru.nsu.fit.kozhevnikova.weather_forecast.domain.model

import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("temp")
    val temperature : Double,
    @SerializedName("pressure")
    val pressure : Double,
    @SerializedName("humidity")
    val humidity : Int,
    @SerializedName("temp_min")
    val minTemperature : Double,
    @SerializedName("temp_max")
    val maxTemperature : Double
)