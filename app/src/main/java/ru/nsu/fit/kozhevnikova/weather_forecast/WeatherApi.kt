package ru.nsu.fit.kozhevnikova.weather_forecast

import org.json.JSONObject
import java.net.HttpURLConnection

import java.net.URL
import java.io.InputStreamReader

import java.io.BufferedReader

import android.R







class WeatherApi {
    private final var OPEN_WEATHER_MAP_API: String =
    "http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric"
    var API_KEY: String = BuildConfig.OPEN_WEATHER_MAP_API_KEY

    public fun getCityWeather(cityName: String) {
        try {
            val url = URL(java.lang.String.format(OPEN_WEATHER_MAP_API, cityName))
            val connection = url.openConnection() as HttpURLConnection
            connection.addRequestProperty("x-api-key", API_KEY)
            val reader = BufferedReader(
                InputStreamReader(connection.inputStream)
            )
            val json = StringBuffer(1024)
            var tmp: String? = ""
            while (reader.readLine().also { tmp = it } != null) json.append(tmp).append("\n")
            reader.close()
            val data = JSONObject(json.toString())

            if (data.getInt("cod") != 200) {
                null
            } else data
        } catch (e: Exception) {
            null
        }
    }
}