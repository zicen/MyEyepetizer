package com.zhenquan.myeyepetizer.mvp.presenter

import com.zhenquan.myeyepetizer.mvp.contract.CategoryContract
import com.zhenquan.myeyepetizer.mvp.model.CategoryModel


class CategoryPresenter(view: CategoryContract.IView) : CategoryContract.IPresenter {


    val categoryView: CategoryContract.IView = view
    val categoryModel: CategoryModel by lazy {
        CategoryModel()
    }


    override fun requestData() {

        categoryModel.loadData()
                .subscribe({ categoryView.showCategory(it) }, {
                    it.printStackTrace()
                    categoryView.onError()
                })

    }

}