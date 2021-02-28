package ru.nsu.fit.kozhevnikova.weather_forecast.ui.List

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.kozhevnikova.weather_forecast.R
import ru.nsu.fit.kozhevnikova.weather_forecast.WeatherForecastApplication
import ru.nsu.fit.kozhevnikova.weather_forecast.ui.CityRepository
import ru.nsu.fit.kozhevnikova.weather_forecast.ui.details.DetailActivity

class ListActivity : AppCompatActivity() {
    private lateinit var cityRepository: CityRepository
    private lateinit var cityList: RecyclerView
    private val adapter = CityAdapter {
        DetailActivity.start(this, it.id)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cityRepository = (application as WeatherForecastApplication).cityRepository
        setContentView(R.layout.activity_list)
        cityList = findViewById(R.id.citiesList)
        cityList.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.cities = cityRepository.getCities()
    }
}