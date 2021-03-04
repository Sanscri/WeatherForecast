package ru.nsu.fit.kozhevnikova.weather_forecast.presentation.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.City
import ru.nsu.fit.kozhevnikova.weather_forecast.data.repository.CityRepositoryImpl

class ListViewModel(private val repositoryImpl: CityRepositoryImpl) : ViewModel() {

    val cityList = MutableLiveData<List<City>>()

    fun loadCity() {
        val city = repositoryImpl.getCities()

        cityList.value = city
    }
}