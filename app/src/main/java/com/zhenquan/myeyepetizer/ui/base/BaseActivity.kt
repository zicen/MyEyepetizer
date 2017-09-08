package com.zhenquan.myeyepetizer.ui.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.Toast

/**
 * Created by zhenquan on 2017/9/8.
 */
abstract class BaseActivity : AppCompatActivity() {


    fun startActivity(context: Context,clazz: Class<*>,  isFinishSelf: Boolean) {
        val intent = Intent(context, clazz)
        startActivity(intent)
        if (isFinishSelf) {
            (context as Activity).finish()
        }
    }
    fun showToast(str: String) {
        val toast = Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }
}