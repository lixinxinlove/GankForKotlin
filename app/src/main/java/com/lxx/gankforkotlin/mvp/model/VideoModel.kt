package com.lxx.gankforkotlin.mvp.model

import android.content.Context
import com.lxx.gankforkotlin.mvp.model.bean.VideoBean
import com.lxx.gankforkotlin.network.ApiService
import com.lxx.gankforkotlin.network.RetrofitClient
import io.reactivex.Observable

/**
 * Created by android on 2017/7/19.
 */
class VideoModel {

    fun loadData(context: Context): Observable<VideoBean>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        return apiService?.getVideoData(30, 1)
    }

    fun loadMoreData(context: Context, page: Int): Observable<VideoBean>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        return apiService?.getVideoData(30, page)
    }

}