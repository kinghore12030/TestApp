package com.example.testapplication.camera.camera2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.TextureView
import androidx.appcompat.app.AppCompatActivity
import com.example.testapplication.R
import com.example.testapplication.camera.CameraMainctivity

class Camera2Activity : AppCompatActivity() {

    lateinit var mTextureView: TextureView

    companion object {
        fun open(context: Context) {
            context.startActivity(Intent(context, Camera2Activity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera2)
        initView()
        initCamera()
    }

    fun initView() {
        mTextureView = findViewById(R.id.textureView1)
    }

    fun initCamera() {
        Camera2Helper(this, mTextureView)
    }
}