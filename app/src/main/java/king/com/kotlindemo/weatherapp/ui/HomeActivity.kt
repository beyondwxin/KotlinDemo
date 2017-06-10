package king.com.kotlindemo.weatherapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.antonioleiva.weatherapp.extensions.DelegatesExt
import com.antonioleiva.weatherapp.ui.activities.SettingsActivity
import king.com.kotlindemo.AgentWebActivity
import king.com.kotlindemo.R
import king.com.kotlindemo.TaskHelper
import king.com.kotlindemo.TaskStatus
import king.com.kotlindemo.adapter.ForecastListAdapter
import king.com.kotlindemo.weatherapp.domain.commands.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

class HomeActivity : AppCompatActivity(), ToolbarManager {
    val zipCode: Long by DelegatesExt.preference(this, SettingsActivity.ZIP_CODE, SettingsActivity.DEFAULT_ZIP)
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initToolBar()
        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)
        TaskHelper.doSth(TaskStatus.COMPLETED)

    }

    override fun onResume() {
        super.onResume()
        loadForecast()
    }

    private fun loadForecast() = doAsync {
        val result = RequestForecastCommand(zipCode).execute()

        uiThread {
            val adapter = ForecastListAdapter(result) {
                startActivity<AgentWebActivity>()
            }
            forecastList.adapter = adapter
            toolBarTitle = "${result.city}+(${result.country})"

        }
    }

}
