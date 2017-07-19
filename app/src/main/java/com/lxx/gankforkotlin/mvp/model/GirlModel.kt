package com.lxx.gankforkotlin.mvp.model

import android.content.Context
import com.lxx.gankforkotlin.mvp.model.bean.GirlBean
import com.lxx.gankforkotlin.network.ApiService
import com.lxx.gankforkotlin.network.RetrofitClient
import io.reactivex.Observable

/**
 * Created by android on 2017/7/19.
 */
class GirlModel {

    fun loadData(context: Context): Observable<GirlBean>? {
        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)
        val apiService = retrofitClient.create(ApiService::class.java)
        return apiService?.getGirlData(10, 1)
    }

}