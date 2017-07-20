package com.lxx.gankforkotlin.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lxx.gankforkotlin.R
import com.lxx.gankforkotlin.mvp.model.bean.AndroidBean
import com.lxx.gankforkotlin.ui.activity.WebActivity

/**
 * Created by android on 2017/7/19.
 */
class AndroidAdapter(var context: Context?, var list: MutableList<AndroidBean.ResultsBean>?) : RecyclerView.Adapter<AndroidAdapter.AndroidViewHolder>() {

    override fun onBindViewHolder(holder: AndroidViewHolder?, position: Int) {
        holder?.tv_desc?.text = list!![position]?.desc
        holder?.tv_publishedAt?.text = list!![position]?.publishedAt
        holder?.tv_source?.text = list!![position]?.source
        holder?.tv_type?.text = list!![position]?.type
        holder?.tv_who?.text = list!![position]?.who


        holder?.itemView?.setOnClickListener {

            var intent = Intent(context, WebActivity::class.java)
            intent.putExtra("url", list!![position].url)
            context?.startActivity(intent)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AndroidViewHolder {
        var view = View.inflate(context, R.layout.item_android, null)
        return AndroidViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    class AndroidViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tv_desc: TextView? = null
        var tv_publishedAt: TextView? = null
        var tv_source: TextView? = null
        var tv_type: TextView? = null
        var tv_who: TextView? = null

        init {
            tv_desc = itemView.findViewById(R.id.tv_desc)
            tv_publishedAt = itemView.findViewById(R.id.tv_publishedAt)
            tv_source = itemView.findViewById(R.id.tv_source)
            tv_type = itemView.findViewById(R.id.tv_type)
            tv_who = itemView.findViewById(R.id.tv_who)
        }
    }
}