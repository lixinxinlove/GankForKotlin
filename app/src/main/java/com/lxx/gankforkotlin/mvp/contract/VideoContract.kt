package com.lxx.gankforkotlin.mvp.contract

import com.lxx.gankforkotlin.base.BasePresenter
import com.lxx.gankforkotlin.base.BaseView
import com.lxx.gankforkotlin.mvp.model.bean.VideoBean

/**
 * Created by android on 2017/7/19.
 */
interface VideoContract {

    interface View : BaseView<Presenter> {

        fun setData(beans: MutableList<VideoBean.ResultsBean>)

        fun setMoreData(beans: MutableList<VideoBean.ResultsBean>)

        fun showRefresh()

        fun showError()

    }

    interface Presenter : BasePresenter {
        fun requestData()
    }
}