package ru.nsu.fit.kozhevnikova.weather_forecast.data.source.remote

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import ru.nsu.fit.kozhevnikova.weather_forecast.domain.model.CurrentWeather
import ru.nsu.fit.kozhevnikova.weather_forecast.util.Constants

interface CurrentWeatherApi {

    @GET(Constants.CURRENT_WEATHER_URL)
    fun getByCityName(@Query(Constants.QUERY_PARAMETER) query: String,
                      @Query(Constants.UNITS_PARAMETER) units: String = "metric",
                      @Query(Constants.ACCURACY_PARAMETER) accuracyType: String = "like",
                      @Query(Constants.LANG_PARAMETER) lang: String = "en")
            : Observable<CurrentWeather>

    @GET(Constants.CURRENT_WEATHER_URL)
    fun getByCityId(@Query(Constants.CITY_ID_PARAMETER) cityId: Int,
                    @Query(Constants.UNITS_PARAMETER) units: String = "metric",
                    @Query(Constants.ACCURACY_PARAMETER) accuracyType: String = "like",
                    @Query(Constants.LANG_PARAMETER) lang: String = "en")
            : Observable<CurrentWeather>

    @GET(Constants.CURRENT_WEATHER_URL)
    fun getByCoordinates(@Query(Constants.LATITUDE_PARAMETER) latitude : Double,
                         @Query(Constants.LONGITUDE_PARAMETER) longitude: Double,
                         @Query(Constants.UNITS_PARAMETER) units: String = "metric",
                         @Query(Constants.ACCURACY_PARAMETER) accuracyType: String = "like",
                         @Query(Constants.LANG_PARAMETER) lang: String = "en")
            : Observable<CurrentWeather>
}