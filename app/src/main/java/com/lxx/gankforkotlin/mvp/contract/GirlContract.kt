package com.lxx.gankforkotlin.mvp.contract

import com.lxx.gankforkotlin.base.BasePresenter
import com.lxx.gankforkotlin.base.BaseView
import com.lxx.gankforkotlin.mvp.model.bean.GirlBean

/**
 * Created by android on 2017/7/19.
 */
interface GirlContract {

    interface View : BaseView<Presenter> {

        fun setData(beans: MutableList<GirlBean.ResultsBean>)

        fun setMoreData(beans: MutableList<GirlBean.ResultsBean>)

        fun showRefresh()

        fun showEorr()

    }

    interface Presenter : BasePresenter {
        fun requestData()
    }
}