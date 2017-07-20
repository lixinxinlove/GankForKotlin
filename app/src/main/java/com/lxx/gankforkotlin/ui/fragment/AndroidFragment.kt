package com.lxx.gankforkotlin.ui.fragment

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import com.lxx.gankforkotlin.R
import com.lxx.gankforkotlin.adapter.AndroidAdapter
import com.lxx.gankforkotlin.base.BaseFragment
import com.lxx.gankforkotlin.mvp.contract.AndroidContract
import com.lxx.gankforkotlin.mvp.model.bean.AndroidBean
import com.lxx.gankforkotlin.mvp.presenter.AndroidPresenter
import kotlinx.android.synthetic.main.fragment_android.*

/**
 * Created by android on 2017/7/19.
 */

class AndroidFragment : BaseFragment(), AndroidContract.View, SwipeRefreshLayout.OnRefreshListener {

    var adapter: AndroidAdapter? = null
    var mList: MutableList<AndroidBean.ResultsBean>? = mutableListOf() //初始化 List

    var mPresenter: AndroidPresenter? = null

    override fun getLayoutResources(): Int {
        return R.layout.fragment_android
    }

    override fun initView() {

        mPresenter = AndroidPresenter(context, this)

        adapter = AndroidAdapter(context, mList)
        recycler_view_android.layoutManager = LinearLayoutManager(context)
        recycler_view_android.adapter = adapter

        refresh_layout_android.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark)
        refresh_layout_android.setOnRefreshListener(this)

        mPresenter?.start()
    }

    override fun setData(beans: MutableList<AndroidBean.ResultsBean>) {
        refresh_layout_android.isRefreshing = false
        mList?.clear()
        mList?.addAll(beans)
        adapter?.list = mList
        adapter?.notifyDataSetChanged()

    }

    override fun setMoreData(beans: MutableList<AndroidBean.ResultsBean>) {
    }

    override fun showRefresh() {
        refresh_layout_android.post { refresh_layout_android.isRefreshing = true }
    }

    override fun showError() {
    }


    override fun onRefresh() {
        mPresenter?.start()
    }


}
