package ru.nsu.fit.kozhevnikova.weather_forecast.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import ru.nsu.fit.kozhevnikova.weather_forecast.R
import ru.nsu.fit.kozhevnikova.weather_forecast.WeatherForecastApplication
import ru.nsu.fit.kozhevnikova.weather_forecast.databinding.ActivityDetailsBinding
import ru.nsu.fit.kozhevnikova.weather_forecast.ui.CityRepository

class DetailActivity : AppCompatActivity() {
    companion object {

        private const val EXTRA_ID = "EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_ID, id)
            context.startActivity(intent)
        }
    }

    private lateinit var cityRepository: CityRepository

    private lateinit var nameText: TextView
    private lateinit var saveButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cityRepository = (application as WeatherForecastApplication).cityRepository
        setContentView(R.layout.activity_details)

        initViews()
    }

    private fun initViews() {
        val id = intent.getLongExtra(EXTRA_ID, 0)
        val city = cityRepository.getCity(id)

        if (city != null) {
            nameText = findViewById(R.id.nameText)
            saveButton = findViewById(R.id.saveButton)

            nameText.text = getString(R.string.name_format, city.name)
            saveButton.setOnClickListener {
                finish()
            }
        } else {
            finish()
        }

    }
}