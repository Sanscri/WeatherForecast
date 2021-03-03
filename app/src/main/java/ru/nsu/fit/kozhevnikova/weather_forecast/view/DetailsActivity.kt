package ru.nsu.fit.kozhevnikova.weather_forecast.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.nsu.fit.kozhevnikova.weather_forecast.R
import ru.nsu.fit.kozhevnikova.weather_forecast.WeatherForecastApplication
import ru.nsu.fit.kozhevnikova.weather_forecast.model.CurrentWeather
import ru.nsu.fit.kozhevnikova.weather_forecast.repository.CityRepository
import ru.nsu.fit.kozhevnikova.weather_forecast.repository.WeatherForecastRepository
import ru.nsu.fit.kozhevnikova.weather_forecast.viewModel.DetailViewModel

class DetailsActivity : AppCompatActivity() {
    companion object {

        private const val EXTRA_ID = "EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(EXTRA_ID, id)
            context.startActivity(intent)
        }
    }

    private lateinit var cityRepository: CityRepository
    private lateinit var weatherForecastRepository: WeatherForecastRepository

    private lateinit var cityTextView: TextView
    private lateinit var temperatureTextView: TextView
    private lateinit var windTextView: TextView
    private lateinit var weatherTextView: TextView
    private lateinit var conditionTextView: TextView
    private lateinit var cloudTextView: TextView
    private lateinit var sysTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cityRepository = (application as WeatherForecastApplication).cityRepository
        weatherForecastRepository = (application as WeatherForecastApplication).weatherForecastRepository
        setContentView(R.layout.activity_details)
        viewModel.weather.observe(this, ::bindPerson)
        viewModel.closeScreenEvent.observe(this) { closeScreen() }
        initViews()
    }
    fun bindPerson(weather: CurrentWeather) {
        sysTextView.text = weather.sys.toString()
        cityTextView.text = weather.cityName
        windTextView.text = weather.wind.toString()
        weatherTextView.text = weather.weather.toString()
        cloudTextView.text = weather.clouds.toString()

    }
    private val viewModel: DetailViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                modelClass
                    .getConstructor(WeatherForecastRepository::class.java, Long::class.java)
                    .newInstance(
                        (application as WeatherForecastApplication).weatherForecastRepository,
                        intent.getLongExtra(EXTRA_ID, 0)
                    )
        }
    }

    private fun initViews() {
        val id = intent.getLongExtra(EXTRA_ID, 0)
        val weatherForecast = weatherForecastRepository.getWeather(id)
        if (weatherForecast != null) {
            cityTextView = findViewById(R.id.textCity)
            windTextView = findViewById(R.id.textWind)
            weatherTextView = findViewById(R.id.textWeather)
            cloudTextView = findViewById(R.id.textCloud)
            sysTextView = findViewById(R.id.textSys)

        } else {
            finish()
        }

    }
    private fun closeScreen() {
        finish()
    }
}