package com.example.testapplication.camera

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.testapplication.R
import com.example.testapplication.camera.camera1.CameraActivity
import com.example.testapplication.camera.camera2.Camera2Activity

class CameraMainctivity : AppCompatActivity(), View.OnClickListener {

    lateinit var mBtnCamera1: Button
    lateinit var mBtnCamera2: Button

    companion object {
        fun open(context: Context) {
            context.startActivity(Intent(context, CameraMainctivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_mainctivity)
        initView()
        initListener()
    }


    fun initView() {
        mBtnCamera1 = findViewById(R.id.btn_camera1)
        mBtnCamera2 = findViewById(R.id.btn_camera2)
    }

    fun initListener() {
        mBtnCamera1.setOnClickListener(this)
        mBtnCamera2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_camera1 -> startActivity(CameraActivity.createIntent(this))
            R.id.btn_camera2 -> Camera2Activity.open(this)
        }
    }
}