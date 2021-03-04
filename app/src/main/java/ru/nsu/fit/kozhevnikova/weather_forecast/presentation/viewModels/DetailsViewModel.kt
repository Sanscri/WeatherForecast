package ru.nsu.fit.kozhevnikova.weather_forecast.presentation.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nsu.fit.kozhevnikova.weather_forecast.util.events.LiveEvent
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.CurrentWeather
import ru.nsu.fit.kozhevnikova.weather_forecast.data.repository.CurrentWeatherRepositoryImpl
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.City
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.usecase.city.GetCityUseCase
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.usecase.weather.GetWeatherUseCase
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.usecase.weather.GetWeathersUserCase
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.usecase.weather.SetWeatherUseCase

class DetailsViewModel(
    getWeatherUserCase: GetWeatherUseCase,
    private val setWeatherUseCase: SetWeatherUseCase,
    id: Long)
    : ViewModel() {
    val currentWeather = MutableLiveData<CurrentWeather>()
    val closeScreenEvent = LiveEvent()
    init {
        val currentWeather  = getWeatherUserCase(id)
        this.currentWeather.value = currentWeather!!
    }
}