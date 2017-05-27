package king.com.kotlindemo

import com.google.gson.Gson
import king.com.kotlindemo.bean.UserResult
import java.net.URL

/**
 * Created by wuxin on 2017/5/27.
 */
class Request(val url: String) {

    companion object {
        private val URL = "http://gank.io/api"
        private val COMPLETE_URL = "$URL"
    }


    fun excute(): UserResult {
        val json = URL(COMPLETE_URL + url).readText()
        return Gson().fromJson(json, UserResult::class.java)
    }

}