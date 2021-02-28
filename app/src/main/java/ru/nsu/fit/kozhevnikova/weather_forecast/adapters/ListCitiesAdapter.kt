package ru.nsu.fit.kozhevnikova.weather_forecast.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.kozhevnikova.weather_forecast.R
import ru.nsu.fit.kozhevnikova.weather_forecast.model.City


class CityAdapter(private val onClick: (City) -> Unit) : RecyclerView.Adapter<CityHolder>() {

    var cities: List<City> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return CityHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        val city = cities[position]
        holder.bind(city)
    }

    override fun getItemCount(): Int = cities.count()
}

class CityHolder(itemView: View, private val onClick: (City) -> Unit) : RecyclerView.ViewHolder(itemView) {

    private val cityText: TextView = itemView.findViewById(R.id.cityName)

    fun bind(city: City) {
        cityText.text =  city.name
        itemView.setOnClickListener { onClick(city) }
    }
}