package ru.nsu.fit.kozhevnikova.weather_forecast.events


class LiveEvent : SingleLiveEvent<Unit>() {

    operator fun invoke() {
        this.value = Unit
    }
}