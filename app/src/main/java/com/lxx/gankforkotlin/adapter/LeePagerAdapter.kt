package com.lxx.gankforkotlin.adapter

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup


/**
 * Created by android on 2017/8/1.
 */
class LeePagerAdapter(list: MutableList<View>) : PagerAdapter() {

    var mData: MutableList<View>? = null

    init {
        mData = list
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        container?.addView(mData!![position])
        return mData!![position]
    }

    override fun destroyItem(container: ViewGroup?, position: Int, obj: Any?) {
        container?.removeView(obj as View)
    }

    override fun isViewFromObject(view: View?, obj: Any?): Boolean {
        return view == obj
    }

    override fun getCount(): Int {
        return mData!!.size
    }

    override fun getItemPosition(obj: Any?): Int {
        return POSITION_NONE
    }

}