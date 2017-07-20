package com.lxx.gankforkotlin.mvp.model.bean

/**
 * Created by android on 2017/7/20.
 */
data class AndroidBean(var isError: Boolean,
                       var results: MutableList<ResultsBean>?) {


    data class ResultsBean(var _id: String?,
                           var createdAt: String?,
                           var desc: String?,
                           var publishedAt: String?,
                           var source: String?,
                           var type: String?,
                           var url: String?,
                           var isUsed: Boolean,
                           var who: String?,
                           var images: List<String>?) {}
}
