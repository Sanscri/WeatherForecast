package ru.nsu.fit.kozhevnikova.weather_forecast.model

import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("speed")
    val speed : Double,

    @SerializedName("deg")
    val degrees : Double
){
    override fun toString(): String {
        return "Ветер: Скорость -$speed; Направление: $degrees"
    }
}