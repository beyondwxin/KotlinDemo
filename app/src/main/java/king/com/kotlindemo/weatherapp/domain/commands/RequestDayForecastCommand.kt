package com.antonioleiva.weatherapp.domain.commands

import com.antonioleiva.weatherapp.domain.model.Forecast
import king.com.kotlindemo.weatherapp.domain.datasources.ForecastProvider

class RequestDayForecastCommand(
        val id: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)
}