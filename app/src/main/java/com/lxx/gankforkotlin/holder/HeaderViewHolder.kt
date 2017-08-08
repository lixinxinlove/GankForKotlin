package com.lxx.gankforkotlin.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.lxx.gankforkotlin.R

/**
 * Created by android on 2017/7/27.
 */
class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var image: ImageView? = null
    init {
        image = itemView.findViewById(R.id.image)
    }
}