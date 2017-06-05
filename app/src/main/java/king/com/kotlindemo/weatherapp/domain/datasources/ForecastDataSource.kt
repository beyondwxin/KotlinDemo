package king.com.kotlindemo.weatherapp.domain.datasources

import com.antonioleiva.weatherapp.domain.model.Forecast
import com.antonioleiva.weatherapp.domain.model.ForecastList

/**
 * Created by wuxin on 2017/6/1.
 */
interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
    fun requestDayForecast(id: Long): Forecast?
}