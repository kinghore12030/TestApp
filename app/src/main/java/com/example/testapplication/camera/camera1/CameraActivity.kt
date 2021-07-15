package com.example.testapplication.camera.camera1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.SurfaceView
import android.view.Window
import android.view.WindowManager
import com.example.testapplication.R

/**
 * Created wangjinhao on 11/23/20.
 */
class CameraActivity : Activity() {

    private var mSurfaceView: SurfaceView? = null
    private var cameraHelper: CameraHelper? = null

    companion object {
        @JvmStatic
        fun createIntent(context: Context?): Intent {
            return Intent(context, CameraActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.layout_camera)
        initView()
        initCamera()
    }

    private fun initView() {
        mSurfaceView = findViewById(R.id.surfaceView)
    }

    private fun initCamera() {
        cameraHelper = CameraHelper(this, mSurfaceView)
    }

}