package ru.nsu.fit.kozhevnikova.weather_forecast.presentation.activities

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
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.CurrentWeather
import ru.nsu.fit.kozhevnikova.weather_forecast.data.repository.CityRepositoryImpl
import ru.nsu.fit.kozhevnikova.weather_forecast.data.repository.WeatherForecastRepositoryImpl
import ru.nsu.fit.kozhevnikova.weather_forecast.presentation.viewModels.DetailsViewModel

class DetailsActivity : AppCompatActivity() {
    companion object {

        private const val EXTRA_ID = "EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(EXTRA_ID, id)
            context.startActivity(intent)
        }
    }

    private lateinit var cityRepositoryImpl: CityRepositoryImpl
    private lateinit var weatherForecastRepositoryImpl: WeatherForecastRepositoryImpl

    private lateinit var cityTextView: TextView
    private lateinit var temperatureTextView: TextView
    private lateinit var windTextView: TextView
    private lateinit var weatherTextView: TextView
    private lateinit var conditionTextView: TextView
    private lateinit var cloudTextView: TextView
    private lateinit var sysTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cityRepositoryImpl = (application as WeatherForecastApplication).cityRepositoryImpl
        weatherForecastRepositoryImpl = (application as WeatherForecastApplication).weatherForecastRepositoryImpl
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
    private val viewModel: DetailsViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                modelClass
                    .getConstructor(WeatherForecastRepositoryImpl::class.java, Long::class.java)
                    .newInstance(
                        (application as WeatherForecastApplication).weatherForecastRepositoryImpl,
                        intent.getLongExtra(EXTRA_ID, 0)
                    )
        }
    }

    private fun initViews() {
        val id = intent.getLongExtra(EXTRA_ID, 0)
        val weatherForecast = weatherForecastRepositoryImpl.getWeather(id)
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