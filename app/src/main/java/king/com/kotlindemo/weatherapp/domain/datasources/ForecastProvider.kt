package king.com.kotlindemo.weatherapp.domain.datasources

import com.antonioleiva.weatherapp.data.db.ForecastDb
import com.antonioleiva.weatherapp.data.server.ForecastServer
import com.antonioleiva.weatherapp.domain.model.Forecast
import com.antonioleiva.weatherapp.domain.model.ForecastList
import com.antonioleiva.weatherapp.extensions.firstResult

/**
 * Created by wuxin on 2017/6/1.
 */
class ForecastProvider(val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {


    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24   //一天中的毫秒数
        val SOURCES by lazy { listOf(ForecastDb(), ForecastServer()) } //此时数据会从db中或server中获取到
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = requestToSources {

        val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        if (res != null && res.size >= days) res else null
    }

    fun requestForecast(id: Long): Forecast = requestToSources { it.requestDayForecast(id) }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS //所有天数的毫秒数

    private fun <T : Any> requestToSources(f: (ForecastDataSource) -> T?): T = sources.firstResult { f(it) }
}