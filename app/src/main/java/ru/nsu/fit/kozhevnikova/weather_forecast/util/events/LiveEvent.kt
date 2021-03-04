package ru.nsu.fit.kozhevnikova.weather_forecast.util.events


class LiveEvent : SingleLiveEvent<Unit>() {

    operator fun invoke() {
        this.value = Unit
    }
}