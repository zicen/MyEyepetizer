package com.zhenquan.myeyepetizer.mvp.model


import com.zhenquan.myeyepetizer.io_main
import com.zhenquan.myeyepetizer.mvp.model.bean.Category
import com.zhenquan.myeyepetizer.net.Network
import io.reactivex.Observable

/**
 * Created by xuekai on 2017/9/3.
 */
class CategoryModel {

    fun loadData(): Observable<ArrayList<Category>> {
        return Network.service.getCategory().io_main()
    }
}