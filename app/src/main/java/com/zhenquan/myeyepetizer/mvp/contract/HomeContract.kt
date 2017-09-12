package com.zhenquan.myeyepetizer.mvp.contract

import com.zhenquan.myeyepetizer.model.bean.Item
import com.zhenquan.myeyepetizer.mvp.base.BasePresenter
import com.zhenquan.myeyepetizer.mvp.base.BaseView
import com.zhenquan.myeyepetizer.mvp.model.bean.HomeBean

/**
 * 首页的契约接口，统一管理view和presenter中的接口，使得二者的功能一目了然
 * Created by xuekai on 2017/8/21.
 */
interface HomeContract {

    interface IView : BaseView<IPresenter> {
        fun setFirstData(homeBean: HomeBean)
        fun setMoreData(itemList:ArrayList<Item>)
        fun onError()
    }




    interface IPresenter : BasePresenter {
        /**
         * 刷新数据、第一次请求你数据
         */
        fun requestFirstData()

        /**
         * 底部加载更多
         */
        fun requestMoreData()
    }
}
