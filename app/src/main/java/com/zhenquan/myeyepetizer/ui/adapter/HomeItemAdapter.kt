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
class HomeItemAdapter(val context: Context, var itemList: ArrayList<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        /* if (position<=5) {
             holder as HomeHeadViewHolder
             holder?.slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
             holder?.slider.setDuration(5000)
             val itemsBean = itemList[position]
             val textSliderView = TextSliderView(context)
             textSliderView.image(itemsBean.data?.cover?.homepage)
             textSliderView.description(itemsBean.data?.title)
             textSliderView.setOnSliderClickListener {
                 //TODO to detail activity
                 *//*  val intent = Intent(context, NewsDetailActivity::class.java)
                  intent.putExtra(Constant.URL, itemsBean.getHref())
                  startActivity(intent)*//*

            }
            holder?.slider.addSlider(textSliderView)

        } else {*/
        val itemdata = itemList[position]
        holder as HomeViewHolder
        Glide.with(context).load(itemdata.data?.cover?.homepage).centerCrop().into(holder?.ivCover)
        holder?.tvTitle?.text = itemdata.data?.title
        holder?.tvTag?.text = durationFormat(itemdata.data?.duration)
        holder?.tvTag2?.text = itemdata.data?.category

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {

        var view = LayoutInflater.from(context).inflate(R.layout.item_home_standard, parent, false)
        return HomeViewHolder(view)

    }


    fun addData(itemList: ArrayList<Item>) {
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return itemList?.size
    }


    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivCover = itemView.findViewById(R.id.iv_cover) as ImageView
        val ivAvatar = itemView.findViewById(R.id.iv_avatar) as ImageView
        val tvTitle = itemView.findViewById(R.id.tv_title) as TextView
        val tvTag = itemView.findViewById(R.id.tv_tag) as TextView
        val tvTag2 = itemView.findViewById(R.id.tv_tag2) as TextView
    }


}