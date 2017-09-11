package com.zhenquan.myeyepetizer.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer
import com.zhenquan.myeyepetizer.R
import com.zhenquan.myeyepetizer.TAG
import com.zhenquan.myeyepetizer.io_main
import com.zhenquan.myeyepetizer.net.Network
import com.zhenquan.myeyepetizer.showToast
import com.zhenquan.myeyepetizer.ui.adapter.HomeItemAdapter
import com.zhenquan.myeyepetizer.ui.base.BaseFragment
import com.zhenquan.myeyepetizer.ui.base.tabsId
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by zhenquan on 2017/9/8.
 */
class HomeFragment : BaseFragment(tabId = tabsId[0]) {

    var loadingMore: Boolean = false
    var nextPageUrl: String? = null
    var adapter: HomeItemAdapter? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_home, null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

        pullrecycler_home.layoutManager = LinearLayoutManager(context)

        pullrecycler_home.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val childCount = pullrecycler_home.childCount
                    val itemCount = pullrecycler_home.layoutManager.itemCount
                    val firstVisibleItem = (pullrecycler_home.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    if (firstVisibleItem + childCount == itemCount) {
                        if (!loadingMore) {
                            loadingMore = true
                            onLoadMore()
                        }
                    }
               }
            }
        })
        //获取数据
        getFirstHomeData()


    }

    private fun getFirstHomeData() {
        Network.service.getFirstHomeData(System.currentTimeMillis()).io_main()
                .subscribe({ homeBean ->
                    Log.e(TAG, homeBean.toString())
                    val itemList = homeBean.issueList[0]?.itemList
                    itemList.filter { (type) -> type == "banner2" }.forEach { item -> itemList.remove(item) }
                    adapter = HomeItemAdapter(context, itemList)
                    pullrecycler_home.adapter = adapter
                    nextPageUrl = homeBean.nextPageUrl

                }, { error ->
                    error.printStackTrace()
                    showToast("网络错误" + error.toString())
                })
    }

    fun onLoadMore() {
        nextPageUrl?.let {
            Network.service.getMoreHomeData(it).io_main()
                    .subscribe({ (issueList, nextPageUrl1) ->
                        //过滤掉banner2item
                        val newItemList = issueList[0].itemList
                        newItemList?.removeAt(0)
                        newItemList.filter { (type) -> type == "banner2" }.forEach { item -> newItemList.remove(item) }
                        nextPageUrl = nextPageUrl1
                        loadingMore = false
                        adapter?.addData(newItemList)
                    } ,{ error ->
                        error.printStackTrace()
                        showToast("网络错误" + error.toString())
                    })
        }
    }

    override fun onPause() {
        super.onPause()
        GSYVideoPlayer.releaseAllVideos()
    }

}
