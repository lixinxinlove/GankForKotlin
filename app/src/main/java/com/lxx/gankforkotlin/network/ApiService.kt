package com.lxx.gankforkotlin.network

import com.lxx.gankforkotlin.mvp.model.bean.AndroidBean
import com.lxx.gankforkotlin.mvp.model.bean.GirlBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by android on 2017/7/19.
 */
interface ApiService {

    companion object {
        val BASE_URL: String
            get() = "http://gank.io/api/data/"
    }

    @GET("福利/{limit}/{page}")
    fun getGirlData(@Path("limit") limit: Int, @Path("page") page: Int?): Observable<GirlBean>


    @GET("Android/{limit}/{page}")
    fun getAndroidData(@Path("limit") limit: Int, @Path("page") page: Int?): Observable<AndroidBean>

}