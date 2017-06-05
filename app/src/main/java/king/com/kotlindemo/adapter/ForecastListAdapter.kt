package king.com.kotlindemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.antonioleiva.weatherapp.domain.model.ForecastList
import com.antonioleiva.weatherapp.domain.model.Forecast
import com.antonioleiva.weatherapp.extensions.ctx
import com.antonioleiva.weatherapp.extensions.toDateString
import com.bumptech.glide.Glide
import king.com.kotlindemo.R
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Created by wuxin on 2017/6/2.
 */
class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return weekForecast.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                itemView.date.text = date.toDateString()
                itemView.description.text = description
                itemView.maxTemperature.text = "${high}°"
                itemView.minTemperature.text = "${low}°"
                Glide.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.setOnClickListener { itemClick(this) }
            }
        }

    }


}