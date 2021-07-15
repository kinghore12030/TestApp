package com.example.testapplication.touchtest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.testapplication.R

/**
 * 用外部拦截法解决滑动冲突的示例
 */
class ScrollTestOutActivity : AppCompatActivity() {

    companion object {

        fun open(context: Context) {
            var intent = Intent(context, ScrollTestOutActivity::class.java)
            context.startActivity(intent)
        }
    }

    private val data = arrayOf("Apple",
                               "Banana",
                               "Orange",
                               "Watermelon",
                               "Pear",
                               "Grape",
                               "Pineapple",
                               "Strawberry",
                               "Cherry",
                               "Mango",
                               "Apple",
                               "Banana",
                               "Orange",
                               "Watermelon",
                               "Pear",
                               "Grape",
                               "Pineapple",
                               "Strawberry",
                               "Cherry",
                               "Mango")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_test_outer)
        showList()
    }

    private fun showList() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        val listView: ListView = findViewById(R.id.demo_lv)
        listView.setAdapter(adapter)
    }
}