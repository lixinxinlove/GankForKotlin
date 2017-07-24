package com.lxx.gankforkotlin.mvp.presenter

import android.content.Context
import com.lxx.gankforkotlin.mvp.contract.VideoDetailsContract

/**
 * Created by android on 2017/7/24.
 */
class VideoDetailsPresenter(context: Context, view: VideoDetailsContract.View) : VideoDetailsContract.Presenter {

    var mContext: Context? = null
    var mView: VideoDetailsContract.View? = null

    init {
        mContext = context
        mView = view
    }

    override fun start() {
        requestData()
    }

    override fun requestData() {
    }

    fun getUrl(url: String) {

        mView?.setData("http://www.bilibili.com/video/av12361744/")
    }
}