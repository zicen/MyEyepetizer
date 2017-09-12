package com.zhenquan.myeyepetizer.mvp.contract

import com.zhenquan.myeyepetizer.mvp.base.BasePresenter
import com.zhenquan.myeyepetizer.mvp.base.BaseView
import com.zhenquan.myeyepetizer.mvp.model.bean.Category
import java.util.*

/**
 * 分类的契约接口，统一管理view和presenter中的接口，使得二者的功能一目了然
 * Created by xuekai on 2017/9/3.
 */
interface CategoryContract {
    interface IView : BaseView<IPresenter> {
        fun showCategory(categorys: ArrayList<Category>)
        fun onError()
    }

    interface IPresenter : BasePresenter {
        fun requestData()
    }
}