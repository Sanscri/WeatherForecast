package ru.nsu.fit.kozhevnikova.weather_forecast.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.nsu.fit.kozhevnikova.weather_forecast.data.repository.CityRepositoryImpl
import ru.nsu.fit.kozhevnikova.weather_forecast.data.source.local.CityDataSourceImpl
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.usecase.city.GetCitiesUseCase

class ListViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val cityDataSource = CityDataSourceImpl()
        val cityRepository = CityRepositoryImpl(cityDataSource)
        val getCitiesUseCase = GetCitiesUseCase(cityRepository)

        return modelClass
            .getConstructor(GetCitiesUseCase::class.java)
            .newInstance(getCitiesUseCase)
    }
}