package com.zhenquan.myeyepetizer.mvp.presenter

import com.zhenquan.myeyepetizer.mvp.contract.CategoryDetailContract
import com.zhenquan.myeyepetizer.mvp.model.CategoryDetailModel
import com.zhenquan.myeyepetizer.mvp.model.bean.Category


class CategoryDetailPresenter(view: CategoryDetailContract.IView) : CategoryDetailContract.IPresenter {


    val categoryView: CategoryDetailContract.IView

    var nextPageUrl = ""

    init {
        categoryView = view
    }

    override fun requestMoreData() {
        categoryDetailModel.loadMoreData(nextPageUrl)
                .subscribe({ issue ->
                    nextPageUrl = issue.nextPageUrl
                    categoryView.setListData(issue.itemList)
                }, {
                    it.printStackTrace()
                    categoryView.onError()
                })
    }

    override fun start(category: Category) {
        categoryView.setHeader(category)
        categoryDetailModel.loadData(category.id)
                .subscribe({ issue ->
                    nextPageUrl = issue.nextPageUrl
                    categoryView.setListData(issue.itemList)
                }, {
                    it.printStackTrace()
                    categoryView.onError()
                })
    }


    val categoryDetailModel: CategoryDetailModel by lazy {
        CategoryDetailModel()
    }

}