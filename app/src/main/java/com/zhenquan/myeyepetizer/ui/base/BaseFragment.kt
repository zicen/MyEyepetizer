package com.zhenquan.myeyepetizer.ui.base

import android.os.Bundle
import com.zhenquan.myeyepetizer.R

/**
 * Created by zhenquan on 2017/9/8.
 */
var currentFragment = R.id.rb_home
val tabsId = listOf(R.id.rb_home, R.id.rb_category, R.id.rb_hot)
abstract class BaseFragment(tabId:Int) :android.support.v4.app.Fragment(){
    var tabId = 0
    init {
        this.tabId = tabId
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}