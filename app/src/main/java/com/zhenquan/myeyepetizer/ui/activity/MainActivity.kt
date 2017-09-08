package com.zhenquan.myeyepetizer.ui.activity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager

import com.zhenquan.myeyepetizer.R
import com.zhenquan.myeyepetizer.ui.base.BaseFragment
import com.zhenquan.myeyepetizer.ui.base.currentFragment
import com.zhenquan.myeyepetizer.ui.base.tabsId
import com.zhenquan.myeyepetizer.ui.fragment.CategoryFragment
import com.zhenquan.myeyepetizer.ui.fragment.HomeFragment
import com.zhenquan.myeyepetizer.ui.fragment.HotFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // initImmersiveStatusBar()
        setRadio()


    }

    /**
    * 設置透明狀態欄
     */
    private fun initImmersiveStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }
    private fun setRadio() {
        rb_home.isChecked = true
        chooseFragment(R.id.rb_home)
        rg_root.setOnCheckedChangeListener { _, checkedId -> chooseFragment(checkedId) }
    }

    private fun chooseFragment(checkedId: Int) {
        currentFragment = checkedId
        val beginTransaction = supportFragmentManager.beginTransaction()
        val fragment = supportFragmentManager.findFragmentByTag(checkedId.toString())
        if (fragment == null) {
            when(checkedId){
                R.id.rb_home -> beginTransaction.add(R.id.fl_content,HomeFragment(),checkedId.toString())
                R.id.rb_hot -> beginTransaction.add(R.id.fl_content,HotFragment(),checkedId.toString())
                R.id.rb_category -> beginTransaction.add(R.id.fl_content,CategoryFragment(),checkedId.toString())
            }
        }

        tabsId.forEach { tab->

            val aFragment = supportFragmentManager.findFragmentByTag(tab.toString()) as BaseFragment?

            if (tab == checkedId) {
                aFragment?.let {
                    beginTransaction.show(it)
                }
            } else {
                aFragment?.let {
                    beginTransaction.hide(it)
                }
            }
        }

        beginTransaction.commit()

    }
}
