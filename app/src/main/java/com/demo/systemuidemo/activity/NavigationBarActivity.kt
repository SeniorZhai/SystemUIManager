package com.demo.systemuidemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.demo.systemuidemo.R
import com.demo.systemuidemo.SystemUIManager
import kotlinx.android.synthetic.main.activity_navigationbar.float_hide_navigation_bar
import kotlinx.android.synthetic.main.activity_navigationbar.normal_hide_navigation_bar

/**
 *
 * Navigation bar 的隐藏
 */

class NavigationBarActivity :AppCompatActivity() ,View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigationbar)
        initView()
    }
    private fun  initView(){
        normal_hide_navigation_bar.setOnClickListener ( this )
        float_hide_navigation_bar.setOnClickListener (this )
    }

    override fun onClick(view: View) {
       when(view.id){
           R.id.normal_hide_navigation_bar->{
               SystemUIManager.setNavigationBarNormalStyle(window)
           }
           R.id.float_hide_navigation_bar->{
               SystemUIManager.setNavigationBarFloatStyle(window)
           }
       }
    }
}
