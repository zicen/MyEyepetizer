package com.zhenquan.myeyepetizer.ui.activity

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.zhenquan.myeyepetizer.R
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //隐藏状态栏
        val decorView = window.decorView
        val option = View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = option


        /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
             val window = window
             window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
             window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
             window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
             window.statusBarColor = Color.TRANSPARENT
         }*/


        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.splash))
        videoView.start()
        videoView.setOnCompletionListener {
            MediaPlayer.OnCompletionListener { v -> v.start() }
        }

        btn_enter.setOnClickListener { Toast.makeText(this, "进入了主页", Toast.LENGTH_SHORT).show(); }
    }
}
