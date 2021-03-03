package ru.nsu.fit.kozhevnikova.weather_forecast.model

import com.google.gson.annotations.SerializedName

class Sys (
    @SerializedName("type")
    val type : Int,
    @SerializedName("id")
    val id : Int,
    @SerializedName("message")
    val message : Double,
    @SerializedName("country")
    val country : String,
    @SerializedName("sunrise")
    val sunrise : Long,
    @SerializedName("sunset")
    val sunset : Long
){
    override fun toString(): String {
        return "Восход солнца: $sunrise, Заход солнца: $sunset"
    }
}