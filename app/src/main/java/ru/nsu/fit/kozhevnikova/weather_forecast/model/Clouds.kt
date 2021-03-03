package ru.nsu.fit.kozhevnikova.weather_forecast.model

import com.google.gson.annotations.SerializedName


data class Clouds(
    @SerializedName("all")
    val cloudiness : Int
){
    override fun toString(): String {
        return "Облачность: $cloudiness"
    }
}