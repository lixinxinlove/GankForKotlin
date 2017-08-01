package com.lxx.gankforkotlin.ui.activity

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.lxx.gankforkotlin.R
import com.lxx.gankforkotlin.adapter.LeePagerAdapter
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    val TAG = "ViewPagerActivity"

    var adapter: LeePagerAdapter? = null

    var list: MutableList<View>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        init()

        view_pager.addOnPageChangeListener(this)
    }

    private fun init() {
        list = ArrayList()
        for (i in 0..5) {
            var view = View.inflate(this, R.layout.item_pager, null)
            list?.add(i, view)
        }
        adapter = LeePagerAdapter(list!!)
        view_pager.adapter = adapter
    }

    override fun onPageScrollStateChanged(state: Int) {
        //  Log.d(TAG, "state== ${state}")
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        Log.d(TAG, "positionOffset== ${positionOffset}")
        //Log.d(TAG, "positionOffsetPixels== ${positionOffsetPixels}")
    }

    override fun onPageSelected(position: Int) {
        Log.d(TAG, "position== ${position}")
    }
}
