package com.lxx.gankforkotlin.mvp.contract

import com.lxx.gankforkotlin.base.BasePresenter
import com.lxx.gankforkotlin.base.BaseView
import com.lxx.gankforkotlin.mvp.model.bean.AndroidBean

/**
 * Created by android on 2017/7/20.
 */
interface AndroidContract {

    interface View : BaseView<Presenter> {

        fun setData(beans: MutableList<AndroidBean.ResultsBean>)

        fun setMoreData(beans: MutableList<AndroidBean.ResultsBean>)

        fun showRefresh()

        fun showError()

    }

    interface Presenter : BasePresenter {
        fun requestData()
    }
}