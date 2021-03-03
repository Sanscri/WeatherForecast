package ru.nsu.fit.kozhevnikova.weather_forecast.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nsu.fit.kozhevnikova.weather_forecast.model.City
import ru.nsu.fit.kozhevnikova.weather_forecast.repository.CityRepository

class ListViewModel(private val repository: CityRepository) : ViewModel() {

    val cityList = MutableLiveData<List<City>>()

    fun loadPeople() {
        val city = repository.getCities()

        cityList.value = city
    }
}