package com.lxx.gankforkotlin.mvp.model

import android.content.Context
import com.lxx.gankforkotlin.mvp.model.bean.AndroidBean
import com.lxx.gankforkotlin.network.ApiService
import com.lxx.gankforkotlin.network.RetrofitClient
import io.reactivex.Observable

/**
 * Created by android on 2017/7/20.
 */
class AndroidModel {

    fun loadData(context: Context): Observable<AndroidBean>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        return apiService?.getAndroidData(10, 1)
    }

    fun loadMoreData(context: Context, page: Int): Observable<AndroidBean>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        return apiService?.getAndroidData(10, page)
    }
}