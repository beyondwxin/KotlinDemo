package king.com.kotlindemo;

import android.widget.Toast;

import com.antonioleiva.weatherapp.ui.App;


/**
 * Created by wuxin on 2017/6/5.
 */

public class TaskHelper {
    public static void doSth(@TaskStatus int status) {
        switch (status) {
            case TaskStatus.UN_KNOW:

                break;
            case TaskStatus.UN_START:
                break;
            case TaskStatus.PROGRESSING:
                break;
            case TaskStatus.COMPLETED:
                Toast.makeText(App.Companion.getInstance(), "df", 100).show();
                break;
        }
    }
}
