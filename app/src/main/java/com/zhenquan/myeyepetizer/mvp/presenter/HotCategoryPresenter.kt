package com.zhenquan.myeyepetizer.mvp.presenter

import com.zhenquan.myeyepetizer.mvp.model.HotModel
import com.zhenquan.myeyepetizerr.mvp.contract.HotContract

class HotCategoryPresenter(view: HotContract.IHotCategoryView) : HotContract.IHotCategoryPresenter {
    override fun requestData(url: String) {
        hotModel.loadListData(url)
                .subscribe({ issue ->
                    hotCategoryView.setListData(issue.itemList)
                }, {
                    it.printStackTrace()
                    hotCategoryView.onError()
                })
    }


    val hotCategoryView: HotContract.IHotCategoryView = view

    val hotModel: HotModel by lazy {
        HotModel()
    }

}