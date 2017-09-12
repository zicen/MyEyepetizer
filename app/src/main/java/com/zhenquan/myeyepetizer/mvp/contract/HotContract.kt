package com.zhenquan.myeyepetizerr.mvp.contract

import com.zhenquan.myeyepetizer.model.bean.Item
import com.zhenquan.myeyepetizer.mvp.base.BasePresenter
import com.zhenquan.myeyepetizer.mvp.base.BaseView
import com.zhenquan.myeyepetizer.mvp.model.bean.HotCategory

/**
 * 热门的契约接口，统一管理view和presenter中的接口，使得二者的功能一目了然
 * Created by xuekai on 2017/9/4.
 */
interface HotContract {
    interface IHotFragmentView : BaseView<IHotFragmentPresenter> {
        fun setTabAndFragment(hotCategory: HotCategory)
        fun onError()
    }

    interface IHotCategoryView : BaseView<IHotCategoryPresenter> {
        fun setListData(itemList:ArrayList<Item>)
        fun onError()
    }

    interface IHotFragmentPresenter : BasePresenter {
        fun requestHotCategory()
    }

    interface IHotCategoryPresenter : BasePresenter {
        fun requestData(url: String)
    }
}