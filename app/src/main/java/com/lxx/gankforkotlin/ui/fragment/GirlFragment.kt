package com.lxx.gankforkotlin.ui.fragment

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.lxx.gankforkotlin.R
import com.lxx.gankforkotlin.adapter.GirlAdapter
import com.lxx.gankforkotlin.base.BaseFragment
import com.lxx.gankforkotlin.mvp.contract.GirlContract
import com.lxx.gankforkotlin.mvp.model.bean.GirlBean.ResultsBean
import com.lxx.gankforkotlin.mvp.presenter.GirlPresenter
import com.tt.lvruheng.eyepetizer.utils.showToast
import kotlinx.android.synthetic.main.fragment_girl.*

/**
 * Created by android on 2017/7/19.
 */
class GirlFragment : BaseFragment(), GirlContract.View, SwipeRefreshLayout.OnRefreshListener {

    var isFirstShow: Boolean = false

    private var page: Int = 1

    var mList: MutableList<ResultsBean>? = mutableListOf() //初始化 List

    private var girlPresenter: GirlPresenter? = null

    private var adapter: GirlAdapter? = null

    private var loading: Boolean = false


    override fun getLayoutResources(): Int {
        return R.layout.fragment_girl
    }

    override fun initView() {

        girlPresenter = GirlPresenter(context, this)

        adapter = GirlAdapter(context, mList)
        recycler_view_girl.layoutManager = LinearLayoutManager(context)
        recycler_view_girl.adapter = adapter

        refresh_layout_girl.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark)
        refresh_layout_girl.setOnRefreshListener(this)

        //添加滑动监听
        recycler_view_girl.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                var layoutManager: LinearLayoutManager = recyclerView?.layoutManager as LinearLayoutManager
                var lastPositon = layoutManager.findLastVisibleItemPosition()
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastPositon == mList?.size) {
                    if (!loading) {
                        page++
                        girlPresenter?.moreData(page)
                        loading = true
                    }
                }
            }

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })

    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden && !isFirstShow) {
            girlPresenter?.start()
            isFirstShow = true
        }
    }


    override fun setData(beans: MutableList<ResultsBean>) {
        refresh_layout_girl.isRefreshing = false
        mList?.clear()
        mList?.addAll(beans)
        adapter?.list = mList
        adapter?.notifyDataSetChanged()
    }

    override fun setMoreData(beans: MutableList<ResultsBean>) {
        mList?.addAll(beans)
        adapter?.list = mList
        adapter?.notifyDataSetChanged()
        loading = false
    }

    override fun showRefresh() {
        refresh_layout_girl.post({ refresh_layout_girl.isRefreshing = true })
    }

    override fun onRefresh() {
        page = 1
        girlPresenter?.requestData()
    }

    override fun showEorr() {
        context.showToast("网络异常")
        refresh_layout_girl.isRefreshing = false
        adapter?.hideFootView()
    }
}

