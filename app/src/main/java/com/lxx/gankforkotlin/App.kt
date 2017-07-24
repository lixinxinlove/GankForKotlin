package com.lxx.gankforkotlin

import android.app.Application
import android.content.Context

/**
 * Created by android on 2017/7/21.
 */
class App : Application() {

    companion object { //伴随 对象
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }

}