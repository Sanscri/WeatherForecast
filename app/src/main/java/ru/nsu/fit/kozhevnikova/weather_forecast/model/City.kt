package ru.nsu.fit.kozhevnikova.weather_forecast.model

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("coord")
    val coordinates: Coordinates,
    @SerializedName("country")
    val country: String
){
    override fun toString(): String {
        return "City: $name ($coordinates) ($country)"
    }
}