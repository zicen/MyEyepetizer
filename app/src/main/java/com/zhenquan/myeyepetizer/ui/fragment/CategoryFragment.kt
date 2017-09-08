package com.zhenquan.myeyepetizer.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhenquan.myeyepetizer.R
import com.zhenquan.myeyepetizer.ui.base.BaseFragment
import com.zhenquan.myeyepetizer.ui.base.tabsId

/**
 * Created by zhenquan on 2017/9/8.
 */
class CategoryFragment : BaseFragment(tabId = tabsId[0]) {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_category, null)
    }

}
