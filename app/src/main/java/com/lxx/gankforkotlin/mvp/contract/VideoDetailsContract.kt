package com.lxx.gankforkotlin.mvp.contract

import com.lxx.gankforkotlin.base.BasePresenter
import com.lxx.gankforkotlin.base.BaseView

/**
 * Created by android on 2017/7/24.
 */
interface VideoDetailsContract {

    interface View : BaseView<Presenter> {

        fun setData(url: String)

        fun showRefresh()

        fun showError()

    }

    interface Presenter : BasePresenter {
        fun requestData()
    }

}