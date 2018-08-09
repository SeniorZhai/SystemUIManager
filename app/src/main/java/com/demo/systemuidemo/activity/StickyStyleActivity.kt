package com.demo.systemuidemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.demo.systemuidemo.R
import com.demo.systemuidemo.SystemUIManager

/**
 * android 4.4 Sticky效果，触摸屏幕，System bar浮现，过一会儿自动消失。
 */
class StickyStyleActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stickystyle)
        SystemUIManager.setStickyStyle(window)
    }
}