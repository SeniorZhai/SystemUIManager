package com.demo.systemuidemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.demo.systemuidemo.activity.DimStyleActivity
import com.demo.systemuidemo.activity.HandleCaseActivity
import com.demo.systemuidemo.activity.ImmersiveStyleActivity
import com.demo.systemuidemo.activity.NavigationBarActivity
import com.demo.systemuidemo.activity.StatusBarNewVersionActivity
import com.demo.systemuidemo.activity.StatusBarOldVersionActivity
import com.demo.systemuidemo.activity.StickyStyleActivity
import kotlinx.android.synthetic.main.activity_main.main_ImmersiveStyle
import kotlinx.android.synthetic.main.activity_main.main_dimStyle
import kotlinx.android.synthetic.main.activity_main.main_handle_case_system_bar
import kotlinx.android.synthetic.main.activity_main.main_navigation_bar_Style
import kotlinx.android.synthetic.main.activity_main.main_new_version_status_bar_Style
import kotlinx.android.synthetic.main.activity_main.main_old_version_status_bar_Style
import kotlinx.android.synthetic.main.activity_main.main_stickyStyle

class MainActivity : AppCompatActivity(), View.OnClickListener {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initView()
  }

  /**
   * 初始化控件
   */
  private fun initView() {
    main_dimStyle.setOnClickListener(this)
    main_old_version_status_bar_Style.setOnClickListener(this)
    main_new_version_status_bar_Style.setOnClickListener(this)
    main_navigation_bar_Style.setOnClickListener(this)
    main_ImmersiveStyle.setOnClickListener(this)
    main_stickyStyle.setOnClickListener(this)
    main_handle_case_system_bar.setOnClickListener(this)

  }

  override fun onClick(view: View) {
    when (view.id) {
      R.id.main_dimStyle -> {
        startActivity(Intent(this, DimStyleActivity::class.java))
      }
      R.id.main_old_version_status_bar_Style -> {
        startActivity(Intent(this, StatusBarOldVersionActivity::class.java))
      }
      R.id.main_new_version_status_bar_Style -> {
        startActivity(Intent(this, StatusBarNewVersionActivity::class.java))
      }
      R.id.main_navigation_bar_Style -> {
        startActivity(Intent(this, NavigationBarActivity::class.java))
      }
      R.id.main_stickyStyle -> {
        startActivity(Intent(this, StickyStyleActivity::class.java))

      }
      R.id.main_ImmersiveStyle -> {
        startActivity(Intent(this, ImmersiveStyleActivity::class.java))
      }
      R.id.main_handle_case_system_bar -> {
        startActivity(Intent(this, HandleCaseActivity::class.java))
      }
    }
  }


}
