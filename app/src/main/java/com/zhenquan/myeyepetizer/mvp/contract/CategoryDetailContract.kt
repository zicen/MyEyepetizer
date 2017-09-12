package com.zhenquan.myeyepetizer.mvp.contract

import com.zhenquan.myeyepetizer.model.bean.Item
import com.zhenquan.myeyepetizer.mvp.base.BasePresenter
import com.zhenquan.myeyepetizer.mvp.base.BaseView
import com.zhenquan.myeyepetizer.mvp.model.bean.Category

/**
 * 分类详情的契约接口，统一管理view和presenter中的接口，使得二者的功能一目了然
 */
interface CategoryDetailContract {
    interface IView : BaseView<IPresenter> {
        fun setHeader(category: Category)
        fun setListData(itemList: ArrayList<Item>)
        fun onError()
    }

    interface IPresenter : BasePresenter {
        fun requestMoreData()

        fun start(category: Category)
    }
}