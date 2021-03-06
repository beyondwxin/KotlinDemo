package com.antonioleiva.weatherapp.data.server

import com.google.gson.Gson
import king.com.kotlindemo.weatherapp.data.server.ForecastResult
import java.net.URL

class ForecastByZipCodeRequest(val zipCode: Long, val gson: Gson = Gson()) {

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        //完整url：http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7&APPID=15646a06818f61f7b8d7823ca833e1ce&q=94043
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return gson.fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}