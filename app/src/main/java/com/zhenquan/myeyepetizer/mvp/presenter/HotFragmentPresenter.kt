package com.zhenquan.myeyepetizer.mvp.presenter

import android.util.Log
import com.zhenquan.myeyepetizer.mvp.model.HotModel
import com.zhenquan.myeyepetizerr.mvp.contract.HotContract


class HotFragmentPresenter(view: HotContract.IHotFragmentView) : HotContract.IHotFragmentPresenter {
    override fun requestHotCategory() {
        hotModel.loadCategoryData("http://baobab.kaiyanapp.com/api/v4/rankList")
                .subscribe({ hotCategory ->
                    Log.i("HotFragmentPresenter", "requestHotCategory-->$hotCategory")
                    hotFragmentView.setTabAndFragment(hotCategory)
                }, {
                    it.printStackTrace()
                    hotFragmentView.onError()
                })
    }

    val hotFragmentView: HotContract.IHotFragmentView = view


    val hotModel: HotModel by lazy {
        HotModel()
    }

}