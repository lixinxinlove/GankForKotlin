package com.lxx.gankforkotlin.ui.fragment

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import com.lxx.gankforkotlin.R
import com.lxx.gankforkotlin.adapter.GirlAdapter
import com.lxx.gankforkotlin.base.BaseFragment
import com.lxx.gankforkotlin.mvp.contract.GirlContract
import com.lxx.gankforkotlin.mvp.model.bean.GirlBean
import com.lxx.gankforkotlin.mvp.presenter.GirlPresenter
import kotlinx.android.synthetic.main.fragment_girl.*

/**
 * Created by android on 2017/7/19.
 */
class GirlFragment : BaseFragment(), GirlContract.View, SwipeRefreshLayout.OnRefreshListener {


    override fun onRefresh() {

    }


    var mList = ArrayList<GirlBean.ResultsBean>()

    private var girlPresenter: GirlPresenter? = null

    private var adapter: GirlAdapter? = null

    override fun getLayoutResources(): Int {
        return R.layout.fragment_girl
    }

    override fun initView() {

        girlPresenter = GirlPresenter(context, this)
        girlPresenter?.start()

        adapter = GirlAdapter(context, mList as MutableList<GirlBean.ResultsBean>?)
        recycler_view_girl.layoutManager = LinearLayoutManager(context)
        recycler_view_girl.adapter = adapter
        
        refresh_layout_girl.setColorSchemeColors(R.color.colorAccent,R.color.colorPrimary,R.color.colorPrimaryDark)
        refresh_layout_girl.setOnRefreshListener(this)
    }
    override fun setData(beans: MutableList<GirlBean.ResultsBean>) {
        mList = beans as ArrayList<GirlBean.ResultsBean>
        adapter?.list = mList
        adapter?.notifyDataSetChanged()
    }
}