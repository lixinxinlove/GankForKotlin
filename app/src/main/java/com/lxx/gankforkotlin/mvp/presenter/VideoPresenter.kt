package com.lxx.gankforkotlin.mvp.presenter

import android.content.Context
import com.lxx.gankforkotlin.mvp.contract.VideoContract
import com.lxx.gankforkotlin.mvp.model.VideoModel
import com.lxx.gankforkotlin.mvp.model.bean.VideoBean
import com.tt.lvruheng.eyepetizer.utils.applySchedulers
import io.reactivex.Observable

/**
 * Created by android on 2017/7/19.
 */
class VideoPresenter(context: Context, view: VideoContract.View) : VideoContract.Presenter {

    var mContext: Context? = null
    var mView: VideoContract.View? = null
    val mModel: VideoModel by lazy {
        VideoModel()
    }

    init {
        mView = view
        mContext = context
    }

    override fun start() {
        requestData()
    }

    override fun requestData() {
        mView?.showRefresh()
        val observable: Observable<VideoBean>? = mContext?.let { mModel.loadData(it) }
        observable?.applySchedulers()?.subscribe({ videoBean: VideoBean ->
            mView?.setData(videoBean.results as MutableList<VideoBean.ResultsBean>)
        }, { x -> mView?.showError() })
    }

    fun moreData(page: Int) {
        mView?.showRefresh()
        val observable: Observable<VideoBean>? = mContext?.let { mModel.loadMoreData(it, page) }
        observable?.applySchedulers()?.subscribe({ girlBean: VideoBean ->
            mView?.setMoreData(girlBean.results as MutableList<VideoBean.ResultsBean>)
        }, { x -> mView?.showError() })
    }
}