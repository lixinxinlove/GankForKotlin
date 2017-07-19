package com.lxx.gankforkotlin.mvp.model.bean

/**
 * Created by android on 2017/7/19.
 */

data class GirlBean(var isError: Boolean?, var results: List<ResultsBean>?) {

    data class ResultsBean(var _id: String?,
                           var createdAt: String?,
                           var desc: String?,
                           var publishedAt: String?,
                           var source: String?,
                           var type: String?,
                           var url: String?,
                           var isUsed: Boolean,
                           var who: String? = null) {}
}
