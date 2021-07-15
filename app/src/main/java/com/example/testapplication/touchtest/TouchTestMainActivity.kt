package com.example.testapplication.touchtest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.testapplication.R

/**
 * 触摸滑动首页
 */
class TouchTestMainActivity : AppCompatActivity(), View.OnClickListener {

    private var mBtnTouchEventTest: Button? = null
    private var mBtnScrollTestInner: Button? = null
    private var mBtnScrollTestOuter: Button? = null

    companion object {

        fun open(context: Context) {
            var intent = Intent(context, TouchTestMainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch_test_main)
        initView()
        initListener()
    }

    private fun initView() {
        mBtnTouchEventTest = findViewById(R.id.btn_touch_event_test)
        mBtnScrollTestInner = findViewById(R.id.btn_scroll_test_inner)
        mBtnScrollTestOuter = findViewById(R.id.btn_scroll_test_outer)
    }

    private fun initListener() {
        mBtnTouchEventTest!!.setOnClickListener(this)
        mBtnScrollTestInner!!.setOnClickListener(this)
        mBtnScrollTestOuter!!.setOnClickListener(this)
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_touch_event_test -> goTouchEventTestPage()
            R.id.btn_scroll_test_inner -> goScrollTestInner()
            R.id.btn_scroll_test_outer -> goScrollTestOuter()
        }
    }

    private fun goTouchEventTestPage() {
        TouchTestActivity.open(this)
    }

    private fun goScrollTestInner() {
        ScrollTestInnerActivity.open(this)
    }

    private fun goScrollTestOuter() {
        ScrollTestOutActivity.open(this)
    }
}