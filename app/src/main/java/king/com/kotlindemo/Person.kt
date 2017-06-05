package king.com.kotlindemo

/**
 * Created by wuxin on 2017/5/31.
 */
class Person {
    var name = ""
        set(value) {
            field = "name：$value" //field被称为预留字段
        }
        get() = field.toUpperCase()
}