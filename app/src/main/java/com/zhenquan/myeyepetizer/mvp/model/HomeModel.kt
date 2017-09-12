package com.zhenquan.myeyepetizer.mvp.model

import com.zhenquan.myeyepetizer.io_main
import com.zhenquan.myeyepetizer.mvp.model.bean.HomeBean
import com.zhenquan.myeyepetizer.net.Network
import io.reactivex.Observable

/**
 * 首页Model，请求默认精选（无date是banner，每次加载更多，加载一条带date）
 * Created by xuekai on 2017/8/20.
 */
class HomeModel {

    fun loadFirstData(): Observable<HomeBean> {
        return Network.service.getFirstHomeData(System.currentTimeMillis()).io_main()
    }

    fun loadMoreData(url: String): Observable<HomeBean> {
        return Network.service.getMoreHomeData(url).io_main()
    }
}