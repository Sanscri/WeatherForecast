package ru.nsu.fit.kozhevnikova.weather_forecast.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.kozhevnikova.weather_forecast.R
import ru.nsu.fit.kozhevnikova.weather_forecast.WeatherForecastApplication
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.City
import ru.nsu.fit.kozhevnikova.weather_forecast.data.repository.CityRepositoryImpl
import ru.nsu.fit.kozhevnikova.weather_forecast.presentation.activities.list.CityAdapter
import ru.nsu.fit.kozhevnikova.weather_forecast.presentation.viewModels.ListViewModel

class CitiesListActivity : AppCompatActivity() {
    private val viewModel: ListViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                modelClass
                    .getConstructor(CityRepositoryImpl::class.java)
                    .newInstance(
                        (application as WeatherForecastApplication).cityRepositoryImpl
                    )
        }
    }
    private lateinit var cityList: RecyclerView
    private val adapter = CityAdapter {
        DetailsActivity.start(this, it.id)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        viewModel.cityList.observe(this, ::bindCityList)
        cityList = findViewById(R.id.citiesList)
        cityList.adapter = adapter
    }
    private fun bindCityList(list: List<City>) {
        adapter.cities = list
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadCity()
    }
}