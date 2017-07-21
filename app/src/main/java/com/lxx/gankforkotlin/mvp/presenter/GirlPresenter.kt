package com.lxx.gankforkotlin.mvp.presenter

import android.content.Context
import com.lxx.gankforkotlin.mvp.contract.GirlContract
import com.lxx.gankforkotlin.mvp.model.GirlModel
import com.lxx.gankforkotlin.mvp.model.bean.GirlBean
import com.tt.lvruheng.eyepetizer.utils.applySchedulers
import io.reactivex.Observable

/**
 * Created by android on 2017/7/19.
 */
class GirlPresenter(context: Context, view: GirlContract.View) : GirlContract.Presenter {

    var mContext: Context? = null
    var mView: GirlContract.View? = null
    val mModel: GirlModel by lazy {
        GirlModel()
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
        val observable: Observable<GirlBean>? = mContext?.let { mModel.loadData(it) }
        observable?.applySchedulers()?.subscribe({ girlBean: GirlBean ->
            mView?.setData(girlBean.results as MutableList<GirlBean.ResultsBean>)
        }, { x-> mView?.showEorr() })


    }

//    fun moreData(page: Int) {
//        mView?.showRefresh()
//        val observable: Observable<GirlBean>? = mContext?.let { mModel.loadMoreData(it, page) }
//        observable?.applySchedulers()?.subscribe { girlBean: GirlBean ->
//            mView?.setMoreData(girlBean.results as MutableList<GirlBean.ResultsBean>)
//        }
//    }

    fun moreData(page: Int) {
        mView?.showRefresh()
        val observable: Observable<GirlBean>? = mContext?.let { mModel.loadMoreData(it, page) }
        observable?.applySchedulers()?.subscribe({ girlBean: GirlBean ->
            mView?.setMoreData(girlBean.results as MutableList<GirlBean.ResultsBean>)

        }, { x -> mView?.showEorr() }

        )


    }


}