package king.com.kotlindemo.weatherapp.domain.commands

import com.antonioleiva.weatherapp.domain.commands.Command
import com.antonioleiva.weatherapp.domain.model.ForecastList
import king.com.kotlindemo.weatherapp.domain.datasources.ForecastProvider

/**
 * Created by wuxin on 2017/6/1.
 */
class RequestForecastCommand(val zipCode: Long, val forecastProvider: ForecastProvider = ForecastProvider()) : Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)
}