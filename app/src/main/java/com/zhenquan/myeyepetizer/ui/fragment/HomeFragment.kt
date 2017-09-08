package com.zhenquan.myeyepetizer.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xk.eyepetizer.TAG
import com.xk.eyepetizer.io_main
import com.zhenquan.myeyepetizer.R
import com.zhenquan.myeyepetizer.net.Network
import com.zhenquan.myeyepetizer.ui.base.BaseFragment
import com.zhenquan.myeyepetizer.ui.base.tabsId

/**
 * Created by zhenquan on 2017/9/8.
 */
class HomeFragment : BaseFragment(tabId = tabsId[0]) {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_home,null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        //获取数据
         Network.service.getFirstHomeData(System.currentTimeMillis()).io_main()
                 .subscribe({ homeBean->
                     Log.e(TAG,homeBean.toString())
                     val nextPageUrl = homeBean.nextPageUrl

                 })



    }

}
