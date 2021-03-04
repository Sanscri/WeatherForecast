package ru.nsu.fit.kozhevnikova.weather_forecast.presentation.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.City
import ru.nsu.fit.kozhevnikova.weather_forecast.data.repository.CityRepositoryImpl
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.usecase.city.GetCitiesUseCase

class ListViewModel(private val getCitiesUseCase: GetCitiesUseCase) : ViewModel() {

    val cityList = MutableLiveData<List<City>>()

    fun loadCities() {
        val cities = getCitiesUseCase()

        cityList.value = cities
    }
}