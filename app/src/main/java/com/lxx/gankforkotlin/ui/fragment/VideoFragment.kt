package com.lxx.gankforkotlin.ui.fragment

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import com.lxx.gankforkotlin.R
import com.lxx.gankforkotlin.adapter.VideoAdapter
import com.lxx.gankforkotlin.base.BaseFragment
import com.lxx.gankforkotlin.mvp.contract.VideoContract
import com.lxx.gankforkotlin.mvp.model.bean.VideoBean
import com.lxx.gankforkotlin.mvp.presenter.VideoPresenter
import kotlinx.android.synthetic.main.fragment_video.*

/**
 * Created by android on 2017/7/19.
 */

class VideoFragment : BaseFragment(), VideoContract.View, SwipeRefreshLayout.OnRefreshListener {

    var isFirstShow: Boolean = true

    private var page: Int = 1

    private var mPresenter: VideoPresenter? = null

    var adapter: VideoAdapter? = null

    var mList: MutableList<VideoBean.ResultsBean>? = mutableListOf() //初始化 List


    override fun getLayoutResources(): Int {
        return R.layout.fragment_video
    }

    override fun initView() {
        mPresenter = VideoPresenter(context, this)
        adapter = VideoAdapter(context, mList)

        recycler_view_video.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recycler_view_video.adapter = adapter

        refresh_view_video.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark)
        refresh_view_video.setOnRefreshListener(this)
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        Log.e("lee2", hidden.toString())
        if (!hidden && isFirstShow) {
            mPresenter?.start()
            isFirstShow = false
        }
    }

    override fun setData(beans: MutableList<VideoBean.ResultsBean>) {
        mList?.clear()
        mList?.addAll(beans)
        adapter?.list = mList
        adapter?.notifyDataSetChanged()
        refresh_view_video.isRefreshing = false
    }

    override fun setMoreData(beans: MutableList<VideoBean.ResultsBean>) {
    }

    override fun showRefresh() {
        refresh_view_video.post { refresh_view_video.isRefreshing = true }
    }

    override fun showError() {
    }

    override fun onRefresh() {

        refresh_view_video.postDelayed({ refresh_view_video.isRefreshing = false }, 3000)

    }

}
