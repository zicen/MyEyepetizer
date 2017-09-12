package com.zhenquan.myeyepetizer

import android.app.Application
import com.zhenquan.myeyepetizer.util.DisplayManager

/**
 * Created by zhenquan on 2017/9/8.
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DisplayManager.init(this)
    }
}