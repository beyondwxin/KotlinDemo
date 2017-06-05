package king.com.kotlindemo

import android.content.Context
import android.widget.Toast

/**
 * Created by wuxin on 2017/5/27.
 */
fun Context.toast(msg: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, msg, length).show()
}
