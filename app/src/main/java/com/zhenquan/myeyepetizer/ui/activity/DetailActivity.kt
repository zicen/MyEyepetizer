package com.zhenquan.myeyepetizer.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhenquan.myeyepetizer.R
import com.zhenquan.myeyepetizer.model.bean.Item
import com.zhenquan.myeyepetizer.mvp.contract.DetailContract
import com.zhenquan.myeyepetizer.mvp.model.bean.Issue
import com.zhenquan.myeyepetizer.mvp.presenter.DetailPresenter
import com.zhenquan.myeyepetizer.ui.adapter.DetailAdapter
import java.util.*

class DetailActivity : AppCompatActivity(), DetailContract.IView {
    lateinit var presenter:DetailPresenter
    val adapter by lazy{ DetailAdapter()}
    var itemData : Item? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

    }
    override fun setPlayer(playUrl: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setMovieAuthorInfo(info: Item) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setRelated(items: ArrayList<Item>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setBackground(url: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDropDownView(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setDropDownView(issue: Issue) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setMoreDropDownView(issue: Issue?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

