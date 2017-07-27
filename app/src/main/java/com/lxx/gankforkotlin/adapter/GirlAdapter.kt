package com.lxx.gankforkotlin.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.lxx.gankforkotlin.R
import com.lxx.gankforkotlin.holder.FootViewHolder
import com.lxx.gankforkotlin.mvp.model.bean.GirlBean
import com.lxx.gankforkotlin.ui.activity.GirlDetailsActivity
import com.tt.lvruheng.eyepetizer.utils.ImageLoadUtils


/**
 * Created by android on 2017/7/19.
 */
class GirlAdapter(var context: Context?, var list: MutableList<GirlBean.ResultsBean>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val ITEM: Int = 0
    val FOOT: Int = 1

    var isHideFootView: Boolean = false

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (getItemViewType(position) == FOOT) {
            holder as FootViewHolder
            if (isHideFootView) {
                holder.itemView.visibility = View.GONE
            } else {
                holder.itemView.visibility = View.VISIBLE
            }
        } else if (getItemViewType(position) == ITEM) {
            holder as GirdViewHolder
            holder?.tv_text?.text = list!![position]?.who
            ImageLoadUtils.display(context!!, holder?.iv_photo!!, list!![position]?.url!!)

            holder.itemView.setOnClickListener {

                //共享动画
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity, holder.iv_photo, "lee")
                val intent = Intent(context, GirlDetailsActivity::class.java)
                intent?.putExtra("url", list!![position].url)
                ActivityCompat.startActivity(context, intent, options.toBundle())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == FOOT) {
            var view = View.inflate(context, R.layout.item_foot, null)
            return FootViewHolder(view)
        } else {
            var view = View.inflate(context, R.layout.item_girl, null)
            return GirdViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        if (list == null) {
            return 0
        } else {
            return list!!.size + 1
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == list?.size) {
            return FOOT
        } else {
            return ITEM
        }
    }

    class GirdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_photo: ImageView? = null
        var tv_text: TextView? = null
        init {
            iv_photo = itemView.findViewById(R.id.iv_photo)
            tv_text = itemView.findViewById(R.id.tv_text)
        }
    }

    fun hideFootView() {
        isHideFootView = true
        this.notifyItemChanged(list!!.size)
    }

    fun showFootView() {
        isHideFootView = true
        this.notifyItemChanged(list!!.size)
    }
}