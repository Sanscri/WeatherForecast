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
import ru.nsu.fit.kozhevnikova.weather_forecast.data.repository.CurrentWeatherRepositoryImpl
import ru.nsu.fit.kozhevnikova.weather_forecast.presentation.viewModels.DetailViewModelFactory
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
    private val viewModel: DetailsViewModel by viewModels{
        val id = intent.getLongExtra(EXTRA_ID, 0)
        DetailViewModelFactory(id)
    }

    private lateinit var cityTextView: TextView
    private lateinit var temperatureTextView: TextView
    private lateinit var windTextView: TextView
    private lateinit var weatherTextView: TextView
    private lateinit var conditionTextView: TextView
    private lateinit var cloudTextView: TextView
    private lateinit var sysTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initViews()
        viewModel.currentWeather.observe(this, ::bindWeather)
        viewModel.closeScreenEvent.observe(this) { closeScreen() }
    }
    private fun bindWeather(weather: CurrentWeather) {
        sysTextView.text = weather.sys.toString()
        cityTextView.text = weather.cityId.toString()
        windTextView.text = weather.wind.toString()
        weatherTextView.text = weather.weather.toString()
        cloudTextView.text = weather.clouds.toString()

    }

    private fun initViews() {
        cityTextView = findViewById(R.id.textCity)
        windTextView = findViewById(R.id.textWind)
        weatherTextView = findViewById(R.id.textWeather)
        cloudTextView = findViewById(R.id.textCloud)
        sysTextView = findViewById(R.id.textSys)

    }
    private fun closeScreen() {
        finish()
    }
}