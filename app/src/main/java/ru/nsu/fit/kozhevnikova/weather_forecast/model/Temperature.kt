package ru.nsu.fit.kozhevnikova.weather_forecast.model

import com.google.gson.annotations.SerializedName

data class Temperature(
    @SerializedName("day")
    val day: Double,
    @SerializedName("min")
    val min: Double,
    @SerializedName("max")
    val max: Double,
    @SerializedName("night")
    val night: Double,
    @SerializedName("eve")
    val evening: Double,
    @SerializedName("morn")
    val morning: Double
    ){
    override fun toString(): String {
        return "Температура дня: $day"
    }
}
