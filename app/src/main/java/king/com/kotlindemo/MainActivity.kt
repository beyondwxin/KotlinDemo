package king.com.kotlindemo

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.wingsofts.gankclient.ui.activity.BaseBindingActivity
import com.wingsofts.gankclient.ui.adapter.UserAdapter
import king.com.kotlindemo.bean.U
import king.com.kotlindemo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.*

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {
    private var datas: MutableList<U>? = null
    private lateinit var mAdapter: UserAdapter


    override fun initView() {
        getData()
        mAdapter = UserAdapter(datas)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mAdapter
//        button1.setOnClickListener { Log.e("df", "button1") }

        recyclerView!!.setHasFixedSize(true)


        button1.setOnClickListener {
            doAsync {
                val json = Request("/data/Android/10/1").run()
                uiThread { toast(json.list.toString()) }
            }
        }

        val p: Person = Person()
        Log.e("aaaa", p.name)

        val (aaa, bbb) = T("wu", "xin")
        Log.e("aaa:" + aaa, "bbb:" + bbb)

    }

    override fun createDataBinding(savedInstanceState: Bundle?): ActivityMainBinding {
        return DataBindingUtil.setContentView(this, R.layout.activity_main)
    }


    private fun getData() {
        datas = ArrayList<U>() as MutableList<U>?
        for (i in 1..100) {
            datas!!.add(U("name" + i, "phone" + i))
        }
    }

    //Anko写法

//    inner class UI : AnkoComponent<MainActivity> {
//        override fun createView(ui: AnkoContext<MainActivity>): View {
//            return with(ui) {
//                linearLayout() {
//                    orientation = LinearLayout.HORIZONTAL
//                    val textView = textView("我是一个TextView") {
//                        textSize = sp(5).toFloat()
//                        textColor = context.resources.getColor(R.color.material_blue_grey_800)
//                    }.lparams {
//                        margin = dip(10)
//                        height = dip(40)
//                        width = wrapContent
//                    }
//                    val name = editText("EditText")
//                    button("Button") {
//                        onClick {
//                            toast("Hello, ${name.text}!")
//                        }
//                    }
//                }
//            }
//        }
//    }
}

