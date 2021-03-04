package ru.nsu.fit.kozhevnikova.weather_forecast.data.source.local

import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.*

class CurrentWeatherDataSourceImpl: CurrentWeatherDataSource {
    private val allWeather = mutableListOf(
        CurrentWeather(
            coordinates = Coordinates(longitude = 13.3, latitude = 11.13),
            weather = listOf(Weather(1, "main", "description", "icon")),
            main = Main(temperature = 12.0, pressure = 11.0, humidity = 13, minTemperature = 11.0, maxTemperature = 12.0),
            wind = Wind(speed = 11.2, degrees = 15.5),
            clouds = Clouds(cloudiness = 11),
            rain = Rain(rainVolume = 12.3),
            snow = Snow(snowVolume = 11.7),
            timeOfData = 14,
            sys = Sys(type = 1, id = 6, message = 15.2, country = "111", sunrise = 111, sunset = 11),
            cityId = 0,
            cityName = "Moscow"
        ),
        CurrentWeather(
            coordinates = Coordinates(longitude = 13.3, latitude = 11.13),
            weather = listOf(Weather(1, "main", "description", "icon")),
            main = Main(temperature = 12.0, pressure = 11.0, humidity = 13, minTemperature = 11.0, maxTemperature = 12.0),
            wind = Wind(speed = 11.2, degrees = 15.5),
            clouds = Clouds(cloudiness = 11),
            rain = Rain(rainVolume = 12.3),
            snow = Snow(snowVolume = 11.7),
            timeOfData = 14,
            sys = Sys(type = 1, id = 6, message = 15.2, country = "111", sunrise = 111, sunset = 11),
            cityId = 1,
            cityName = "Novosibirsk"
        ),
        CurrentWeather(
            coordinates = Coordinates(longitude = 13.3, latitude = 11.13),
            weather = listOf(Weather(1, "main", "description", "icon")),
            main = Main(temperature = 12.0, pressure = 11.0, humidity = 13, minTemperature = 11.0, maxTemperature = 12.0),
            wind = Wind(speed = 11.2, degrees = 15.5),
            clouds = Clouds(cloudiness = 11),
            rain = Rain(rainVolume = 12.3),
            snow = Snow(snowVolume = 11.7),
            timeOfData = 14,
            sys = Sys(type = 1, id = 6, message = 15.2, country = "111", sunrise = 111, sunset = 11),
            cityId = 2,
            cityName = "London"
        ),
        CurrentWeather(
            coordinates = Coordinates(longitude = 13.3, latitude = 11.13),
            weather = listOf(Weather(1, "main", "description", "icon")),
            main = Main(temperature = 12.0, pressure = 11.0, humidity = 13, minTemperature = 11.0, maxTemperature = 12.0),
            wind = Wind(speed = 11.2, degrees = 15.5),
            clouds = Clouds(cloudiness = 11),
            rain = Rain(rainVolume = 12.3),
            snow = Snow(snowVolume = 11.7),
            timeOfData = 14,
            sys = Sys(type = 1, id = 6, message = 15.2, country = "111", sunrise = 111, sunset = 11),
            cityId = 3,
            cityName = "New York"
        ),
        CurrentWeather(
            coordinates = Coordinates(longitude = 13.3, latitude = 11.13),
            weather = listOf(Weather(1, "main", "description", "icon")),
            main = Main(temperature = 12.0, pressure = 11.0, humidity = 13, minTemperature = 11.0, maxTemperature = 12.0),
            wind = Wind(speed = 11.2, degrees = 15.5),
            clouds = Clouds(cloudiness = 11),
            rain = Rain(rainVolume = 12.3),
            snow = Snow(snowVolume = 11.7),
            timeOfData = 14,
            sys = Sys(type = 1, id = 6, message = 15.2, country = "111", sunrise = 111, sunset = 11),
            cityId = 4,
            cityName = "Paris"
        )
    )

    override fun getWeathers(): List<CurrentWeather>{
        return allWeather
    }
    override fun getWeather(id: Long): CurrentWeather? = allWeather.firstOrNull { it.cityId == id }

    override fun setWeather(currentWeather: CurrentWeather) {
        val editCityIndex = allWeather.indexOfFirst { it.cityId == currentWeather.cityId }
        if (editCityIndex >= 0) {
            allWeather[editCityIndex] = currentWeather
        }
    }
}