package com.lxx.gankforkotlin.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import com.lxx.gankforkotlin.R

/**
 * Created by android on 2017/7/27.
 */
class FootViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var progressBar: ProgressBar? = null
    init {
        progressBar = itemView.findViewById(R.id.progressBar)
    }
}