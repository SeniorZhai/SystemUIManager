package com.demo.systemuidemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.demo.systemuidemo.R
import com.demo.systemuidemo.SystemUIManager

/**
 *
 * 处理window焦点，system bar 显示监听器，点击或者触摸事件
 *
 */
class HandleCaseActivity : AppCompatActivity() {
  private var tag = HandleCaseActivity::class.java.simpleName
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initView()
    setSystemUIChangeListener()
    setGestureHandler()
  }

  private fun initView() {
    val rootView = View.inflate(this, R.layout.activity_handle_case, null)
    setContentView(rootView)
    rootView.isClickable = true
    rootView.setOnTouchListener { view, motionEvent ->
      gestureDetector.onTouchEvent(motionEvent)
    }
  }

  /**
   * 当焦点占据时候，隐藏system bar.
   */
  override fun onWindowFocusChanged(hasFocus: Boolean) {
    SystemUIManager.setStickyStyle(window)
    super.onWindowFocusChanged(hasFocus)
  }

  /**
   * 监听System bar异步改变，来控制actionbar。
   */
  private fun setSystemUIChangeListener() {
    /**
     * 当system bar 设置LOW_PROFILE, HIDE_NAVIGATION, or FULLSCREEN flags，会触发
     */
    window.decorView.setOnSystemUiVisibilityChangeListener { visibility ->
      if ((visibility and View.SYSTEM_UI_FLAG_HIDE_NAVIGATION) == 0) {// system bar可见
        SystemUIManager.setStickyStyle(window)
        showToast(" system bar 显示出来")
      } else {// system bar不可见
        showToast(" system bar被隐藏")
      }
    }
  }

  /**
   * 显示Toast弹窗
   */
  fun showToast(string: String) {
    Toast.makeText(applicationContext, string, Toast.LENGTH_SHORT).show()
  }

  /**
   * 手势处理类
   */
  lateinit var gestureDetector: GestureDetector

  /**
   * 添加手势处理
   */
  private fun setGestureHandler() {
    //创建一个 Gesture Detector来处理onTouch()中信息。
    gestureDetector = GestureDetector(this.applicationContext,
        object : GestureDetector.SimpleOnGestureListener() {
          override fun onSingleTapUp(e: MotionEvent): Boolean {
            val visible = (window.decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_HIDE_NAVIGATION) == 0
            if (visible) {//单击导致SystemBar可见，则进行隐藏
              showToast("onSingleTapUp响应： 触摸屏幕system bar 显示出来，进行再次隐藏")
              SystemUIManager.setStickyStyle(window)
            }
            return true
          }
        })
    gestureDetector.setIsLongpressEnabled(false)
  }

}