package king.com.kotlindemo.weatherapp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.antonioleiva.weatherapp.domain.commands.RequestDayForecastCommand
import com.antonioleiva.weatherapp.domain.model.Forecast
import com.antonioleiva.weatherapp.domain.model.ForecastList
import com.antonioleiva.weatherapp.extensions.color
import com.antonioleiva.weatherapp.extensions.textColor
import com.bumptech.glide.Glide
import king.com.kotlindemo.R
import king.com.kotlindemo.weatherapp.domain.commands.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

class DetailActivity : AppCompatActivity(), ToolbarManager {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    companion object {
        val ID = "DetailActivity:id"
        val CITY_NAME = "DetailActivity:cityName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initToolBar()

        toolBarTitle = intent.getStringExtra(CITY_NAME)
        enableHomeAsUp { onBackPressed() }

        doAsync {
            val result = RequestDayForecastCommand(intent.getLongExtra(ID, -1)).execute()

            uiThread { bindForeCast(result) }
        }


    }

    fun bindForeCast(forecast: Forecast) = with(forecast) {
        Glide.with(ctx).load(iconUrl).into(icon)
        weatherDescription.text = description
        bindWeather(high to maxTemperature, low to minTemperature)
    }

    fun bindWeather(vararg views: Pair<Int, TextView>) = views.forEach {
        it.second.text = "${it.first}°"
        it.second.textColor = color(when (it.first) {
            in -50..0 -> android.R.color.holo_red_dark
            in 0..50 -> android.R.color.holo_orange_dark
            else -> android.R.color.holo_green_dark
        })

    }
}
