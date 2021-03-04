package ru.nsu.fit.kozhevnikova.weather_forecast.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.nsu.fit.kozhevnikova.weather_forecast.data.repository.CurrentWeatherRepositoryImpl
import ru.nsu.fit.kozhevnikova.weather_forecast.data.source.local.CurrentWeatherDataSourceImpl
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.usecase.weather.GetWeatherUseCase
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.usecase.weather.SetWeatherUseCase


class DetailViewModelFactory(private val id: Long) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val currentWeatherDataSource = CurrentWeatherDataSourceImpl()
        val currentWeatherRepository = CurrentWeatherRepositoryImpl(currentWeatherDataSource)
        val getWeatherUseCase = GetWeatherUseCase(currentWeatherRepository)
        val setWeatherUseCase = SetWeatherUseCase(currentWeatherRepository)

        return modelClass
            .getConstructor(
                getWeatherUseCase::class.java,
                setWeatherUseCase::class.java,
                Long::class.java
            )
            .newInstance(getWeatherUseCase, setWeatherUseCase, id)
    }
}