package com.demo.systemuidemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.demo.systemuidemo.R
import com.demo.systemuidemo.SystemUIManager
import kotlinx.android.synthetic.main.activity_statusbarnewversion.float_hide_status_bar
import kotlinx.android.synthetic.main.activity_statusbarnewversion.normal_hide_status_bar

/**
 *
 * Android 4.1及其以上版本控制StatusBar
 */
class StatusBarNewVersionActivity:AppCompatActivity() ,View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statusbarnewversion)
        initView()
    }
    private fun initView(){
        normal_hide_status_bar.setOnClickListener (this )
        float_hide_status_bar.setOnClickListener (this )
    }
    override fun onClick(view: View) {
        when(view.id){
            R.id.normal_hide_status_bar->{
                SystemUIManager.setStatusNormalStyle(window)
            }
            R.id.float_hide_status_bar->{
                SystemUIManager.setStatusFloatStyle(window)
            }
        }
    }
}