package ru.nsu.fit.kozhevnikova.weather_forecast.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nsu.fit.kozhevnikova.weather_forecast.events.LiveEvent
import ru.nsu.fit.kozhevnikova.weather_forecast.model.CurrentWeather
import ru.nsu.fit.kozhevnikova.weather_forecast.repository.WeatherForecastRepository

class DetailViewModel(
    private val repository: WeatherForecastRepository,
    id: Long
) : ViewModel() {

    val weather = MutableLiveData<CurrentWeather>()

    val closeScreenEvent = LiveEvent()

    init {
        val weather = repository.getWeather(id)

        if (weather != null) {
            this.weather.value = weather
        } else {
            closeScreenEvent(Unit)
        }

    }
}