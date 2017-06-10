package king.com.kotlindemo.weatherapp.ui

import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.antonioleiva.weatherapp.extensions.ctx
import com.antonioleiva.weatherapp.extensions.slideEnter
import com.antonioleiva.weatherapp.extensions.slideExit
import com.antonioleiva.weatherapp.ui.App
import com.antonioleiva.weatherapp.ui.activities.SettingsActivity
import king.com.kotlindemo.R
import king.com.kotlindemo.toast
import org.jetbrains.anko.startActivity

/**
 * Created by wuxin on 2017/6/1.
 * ToolbarManager
 */
interface ToolbarManager {
    val toolbar: Toolbar
    var toolBarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }

    fun initToolBar() {
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_settings ->
                    toolbar.ctx.startActivity<SettingsActivity>()
                else -> App.instance.toast("Unknown option")
            }
            true

        }
    }

    fun enableHomeAsUp(up: () -> Unit) {
        toolbar.navigationIcon = createUpDrawable()
        toolbar.setNavigationOnClickListener { up() }
    }

    private fun createUpDrawable() = DrawerArrowDrawable(toolbar.ctx).apply { progress = 1f }

    fun attachToScroll(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                //dy : 垂直滚动距离 dy > 0时为手指向上滚动, 列表滚动显示下面的内容 dy < 0时为手指向下滚动, 列表滚动显示上面的内容
                if (dy > 0) toolbar.slideExit() else toolbar.slideEnter()
            }
        })
    }
}