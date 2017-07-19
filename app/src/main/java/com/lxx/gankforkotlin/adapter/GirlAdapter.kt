package com.lxx.gankforkotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.lxx.gankforkotlin.R
import com.lxx.gankforkotlin.mvp.model.bean.GirlBean
import com.tt.lvruheng.eyepetizer.utils.ImageLoadUtils

/**
 * Created by android on 2017/7/19.
 */
class GirlAdapter(var context: Context?, var list: MutableList<GirlBean.ResultsBean>?) : RecyclerView.Adapter<GirlAdapter.GirdViewHolder>() {

    override fun onBindViewHolder(holder: GirdViewHolder?, position: Int) {

        holder?.tv_text?.text = list!![position]?.url

        ImageLoadUtils.display(context!!, holder?.iv_photo!!, list!![position]?.url!!)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GirdViewHolder {
        var view = View.inflate(context, R.layout.item_girl, null)
        return GirdViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    class GirdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var iv_photo: ImageView? = null
        var tv_text: TextView? = null

        init {
            iv_photo = itemView.findViewById(R.id.iv_photo)
            tv_text = itemView.findViewById(R.id.tv_text)
        }
    }
}