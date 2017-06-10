package king.com.kotlindemo;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by wuxin on 2017/6/5.
 */

@IntDef({
        TaskStatus.UN_KNOW,
        TaskStatus.UN_START,
        TaskStatus.PROGRESSING,
        TaskStatus.COMPLETED
})
@Retention(RetentionPolicy.SOURCE)
public @interface TaskStatus {
    int UN_KNOW = -1;
    int UN_START = 0;
    int PROGRESSING = 1;
    int COMPLETED = 2;
}