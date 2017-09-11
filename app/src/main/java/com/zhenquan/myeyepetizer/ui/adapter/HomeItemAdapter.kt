package com.zhenquan.myeyepetizer.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.xk.eyepetizer.mvp.model.bean.Item
import com.zhenquan.myeyepetizer.R
import com.zhenquan.myeyepetizer.durationFormat


/**
 * Created by zhenquan on 2017/9/11.
 */
class HomeItemAdapter(val context: Context, var itemList: ArrayList<Item>) : RecyclerView.Adapter<HomeItemAdapter.HomeViewHolder>() {


    fun addData(itemList: ArrayList<Item>) {
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: HomeViewHolder?, position: Int) {
        val itemdata = itemList[position]
        Glide.with(context).load(itemdata.data?.cover?.homepage).centerCrop().into(holder?.ivCover)
        Glide.with(context).load(itemdata.data?.cover?.homepage).centerCrop().into(holder?.ivCover)
        holder?.tvTitle?.text = itemdata.data?.title
        holder?.tvTag?.text = durationFormat(itemdata.data?.duration)
        holder?.tvTag2?.text = itemdata.data?.category

    }

    override fun getItemCount(): Int {
        return itemList?.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeViewHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.item_home_standard, parent, false)
        var holder = HomeViewHolder(view)
        return holder
    }


    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivCover = itemView.findViewById(R.id.iv_cover) as ImageView
        val ivAvatar = itemView.findViewById(R.id.iv_avatar) as ImageView
        val tvTitle = itemView.findViewById(R.id.tv_title) as TextView
        val tvTag = itemView.findViewById(R.id.tv_tag) as TextView
        val tvTag2 = itemView.findViewById(R.id.tv_tag2) as TextView
    }

}