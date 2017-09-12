package com.zhenquan.myeyepetizer.mvp.presenter

import com.zhenquan.myeyepetizer.mvp.contract.HomeContract
import com.zhenquan.myeyepetizer.mvp.model.HomeModel
import com.zhenquan.myeyepetizer.mvp.model.bean.HomeBean


class HomePresenter(view: HomeContract.IView) : HomeContract.IPresenter {
    val homeView: HomeContract.IView = view
    var nextPageUrl: String? = null
    val homeModel: HomeModel by lazy {
        HomeModel()
    }


    var bannerHomeBean: HomeBean? = null


    override fun requestFirstData() {
        homeModel.loadFirstData()
                .flatMap({ homeBean ->
                    //也可以在这里过滤掉banner2，不过在homebanner里做了过滤，就懒得改了
                    bannerHomeBean = homeBean
                    homeModel.loadMoreData(homeBean.nextPageUrl)
                })
                .subscribe({ homeBean ->
                    nextPageUrl = homeBean.nextPageUrl
                    bannerHomeBean!!.issueList[0].count = bannerHomeBean!!.issueList[0].itemList.size//这里记录轮播图的长度，在adapter中用

                    //过滤掉banner2item
                    val newItemList = homeBean.issueList[0].itemList
                    newItemList.filter { item -> item.type == "banner2" }.forEach { item -> newItemList.remove(item)  }

                    bannerHomeBean?.issueList!![0].itemList.addAll(newItemList)
                    homeView.setFirstData(bannerHomeBean!!)
                }, { t ->
                    t.printStackTrace()
                    homeView.onError()
                })
    }

    override fun requestMoreData() {
        nextPageUrl?.let {
            homeModel.loadMoreData(it)
                    .subscribe({ homeBean ->

                        //过滤掉banner2item
                        val newItemList = homeBean.issueList[0].itemList
                        newItemList.filter { item -> item.type == "banner2" }.forEach { item -> newItemList.remove(item)  }
                        homeView.setMoreData(newItemList)
                        nextPageUrl = homeBean.nextPageUrl
                    })
        }
    }

}