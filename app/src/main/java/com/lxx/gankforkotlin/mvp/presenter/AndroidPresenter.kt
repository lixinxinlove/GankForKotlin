package com.lxx.gankforkotlin.mvp.presenter

import android.content.Context
import com.lxx.gankforkotlin.mvp.contract.AndroidContract
import com.lxx.gankforkotlin.mvp.model.AndroidModel
import com.lxx.gankforkotlin.mvp.model.bean.AndroidBean
import com.tt.lvruheng.eyepetizer.utils.applySchedulers
import io.reactivex.Observable

/**
 * Created by android on 2017/7/20.
 */
class AndroidPresenter(context: Context, view: AndroidContract.View) : AndroidContract.Presenter {

    var mContext: Context? = null
    var mView: AndroidContract.View? = null
    val mModel: AndroidModel by lazy {
        AndroidModel()
    }

    init {
        mView = view
        mContext = context
    }

    override fun start() {
        requestData()
    }


    override fun requestData() {
        val observable: Observable<AndroidBean>? = mContext?.let { mModel.loadData(it) }
        observable?.applySchedulers()?.subscribe({ androidBean: AndroidBean ->
            mView?.setData(androidBean.results as MutableList<AndroidBean.ResultsBean>)
        })

    }

}