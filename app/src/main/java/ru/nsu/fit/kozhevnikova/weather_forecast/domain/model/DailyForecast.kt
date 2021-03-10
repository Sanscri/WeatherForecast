package ru.nsu.fit.kozhevnikova.weather_forecast.domain.model

import com.google.gson.annotations.SerializedName

data class DailyForecast(
    @SerializedName("list")
    var forecasts: List<OneDayForecast>
)