package com.zhenquan.myeyepetizer.ui.activity

import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import com.zhenquan.myeyepetizer.R
import com.zhenquan.myeyepetizer.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        initVideoView()

        btn_enter.setOnClickListener {  startActivity(SplashActivity@this,MainActivity::class.java,true)  }
    }

    private fun initVideoView() {
        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.splash))
        videoView.setOnPreparedListener({
            it.start()
            it.isLooping = true
        })

        videoView.setOnCompletionListener {
            MediaPlayer.OnCompletionListener {
                it.start()
            }
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            val decorView = window.decorView
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
    }
}
