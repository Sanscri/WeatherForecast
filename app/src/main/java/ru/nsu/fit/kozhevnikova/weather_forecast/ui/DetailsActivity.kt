package ru.nsu.fit.kozhevnikova.weather_forecast.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.nsu.fit.kozhevnikova.weather_forecast.R
import ru.nsu.fit.kozhevnikova.weather_forecast.WeatherForecastApplication
import ru.nsu.fit.kozhevnikova.weather_forecast.repository.CityRepository
import ru.nsu.fit.kozhevnikova.weather_forecast.repository.WeatherForecastRepository

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

        initViews()
    }

    private fun initViews() {
        val id = intent.getLongExtra(EXTRA_ID, 0)
        val weatherForecast = weatherForecastRepository.getWeather(id)
        if (weatherForecast != null) {
            cityTextView = findViewById(R.id.textCity)
            cityTextView.text = weatherForecast.city.toString()

            temperatureTextView = findViewById(R.id.textTemperature)
            temperatureTextView.text =  weatherForecast.temperature.toString()

            windTextView = findViewById(R.id.textWind)
            windTextView.text = weatherForecast.wind.toString()

            weatherTextView = findViewById(R.id.textWeather)
            weatherTextView.text = weatherForecast.currentWeather.toString()

            conditionTextView = findViewById(R.id.textCondition)
            conditionTextView.text = weatherForecast.currentCondition.toString()

            cloudTextView = findViewById(R.id.textCloud)
            cloudTextView.text = weatherForecast.cloud.toString()

            sysTextView = findViewById(R.id.textSys)
            sysTextView.text = weatherForecast.sys.toString()


        } else {
            finish()
        }

    }
}