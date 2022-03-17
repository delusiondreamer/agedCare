package com.example.agedcare

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        val ll = findViewById<View>(R.id.ll) as LinearLayout
        val et = findViewById<View>(R.id.et) as EditText
        ll.setOnClickListener {
            ll.visibility = View.GONE
            et.requestFocus()
            val imm =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(et, 0)
            et.isCursorVisible = true
        }

        //循环输出游戏购物应用宝
        val lv = findViewById<View>(R.id.lv) as ListView
        val mList = arrayOf("游戏", "购物", "应用宝")
        val img = intArrayOf(R.mipmap.game, R.mipmap.shop, R.mipmap.ststem)
        val list: MutableList<ListBean> = ArrayList<ListBean>()
        for (i in mList.indices) {
            val lb = ListBean()
            lb.img = img[i]
            lb.tv = mList[i]
            list.add(lb)
        }
        lv.adapter = ListAdapter(this, list)

        //循环输出吃喝玩乐等
        val lv1 = findViewById<View>(R.id.lv1) as ListView
        val text1 = arrayOf("附近的群", "吃喝玩乐", "同城服务")
        val img1 = intArrayOf(R.mipmap.nearbygroup, R.mipmap.wine, R.mipmap.city)
        val list1: MutableList<List2Bean> = ArrayList<List2Bean>()
        for (j in text1.indices) {
            val lb = List2Bean()
            lb.img = img1[j]
            lb.text = text1[j]
            list1.add(lb)
        }
        lv1.adapter = List2Adapter(this, list1)
    }
}