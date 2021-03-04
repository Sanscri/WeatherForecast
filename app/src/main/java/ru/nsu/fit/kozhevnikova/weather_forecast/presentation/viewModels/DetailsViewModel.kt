package ru.nsu.fit.kozhevnikova.weather_forecast.presentation.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nsu.fit.kozhevnikova.weather_forecast.util.events.LiveEvent
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.CurrentWeather
import ru.nsu.fit.kozhevnikova.weather_forecast.data.repository.WeatherForecastRepositoryImpl

class DetailsViewModel(
    private val repositoryImpl: WeatherForecastRepositoryImpl,
    id: Long
) : ViewModel() {

    val weather = MutableLiveData<CurrentWeather>()

    val closeScreenEvent = LiveEvent()

    init {
        val weather = repositoryImpl.getWeather(id)

        if (weather != null) {
            this.weather.value = weather
        } else {
            closeScreenEvent(Unit)
        }

    }
}