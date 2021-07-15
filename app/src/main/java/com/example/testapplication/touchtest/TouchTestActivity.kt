package com.example.testapplication.touchtest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapplication.R

public class TouchTestActivity : AppCompatActivity() {

    companion object {

        fun open(context: Context) {
            var intent = Intent(context, TouchTestActivity::class.java)
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch_test)
    }
}