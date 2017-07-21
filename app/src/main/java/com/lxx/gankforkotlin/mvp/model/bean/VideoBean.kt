package com.lxx.gankforkotlin.mvp.model.bean

/**
 * Created by android on 2017/7/21.
 */

data class VideoBean(var isError: Boolean,
                     var results: List<ResultsBean>) {

    /**
     * error : false
     * results : [{"_id":"596f5ca8421aa90c9203d3c3","createdAt":"2017-07-19T21:20:40.76Z","desc":"机场里建森林，投资1200亿，有40米高瀑布，搞的一堆人忘了上飞机","publishedAt":"2017-07-20T15:11:16.10Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av12360684/","used":true,"who":"LHF"},{"_id":"59525f2e421aa90ca209c3c7","createdAt":"2017-06-27T21:35:42.903Z","desc":"【科普】铁血战士：生猛的战斗民族","publishedAt":"2017-07-19T13:23:20.375Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av11636124/","used":true,"who":"LHF"},{"_id":"596cd4f2421aa90ca3bb6b1e","createdAt":"2017-07-17T23:17:06.865Z","desc":"【敖厂长】20年前的电子游戏森林冒险","publishedAt":"2017-07-18T16:12:55.381Z","source":"chrome","type":"休息视频","url":"https://www.bilibili.com/video/av12293375/","used":true,"who":"LHF"},{"_id":"596b74d3421aa90ca209c474","createdAt":"2017-07-16T22:14:43.701Z","desc":"10年前的动画比真人还真实！阿斗带你速看顶尖CG《贝奥武夫》爵迹可否一战","publishedAt":"2017-07-17T12:22:21.307Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av12261700/","used":true,"who":"LHF"},{"_id":"59637fdc421aa90ca209c42e","createdAt":"2017-07-10T21:23:40.85Z","desc":"【脑洞菌】漫威秘密战争Part9：主宇宙与终极宇宙的终结","publishedAt":"2017-07-14T13:24:31.177Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av12057192/","used":true,"who":"LHF"},{"_id":"59663b7e421aa90ca209c450","createdAt":"2017-07-12T23:08:46.448Z","desc":"【敖厂长】创世战斗机","publishedAt":"2017-07-13T12:28:15.167Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av12073366/","used":true,"who":"LHF"},{"_id":"59620fa2421aa90ca209c422","createdAt":"2017-07-09T19:12:34.844Z","desc":"细读经典 01: 最伟大的励志电影《肖申克的救赎》","publishedAt":"2017-07-12T13:05:59.766Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av12034193/","used":true,"who":"LHF"},{"_id":"5961c646421aa90ca209c41d","createdAt":"2017-07-09T13:59:34.883Z","desc":"浪漫爱情短片《你我这辈子》","publishedAt":"2017-07-11T13:46:33.911Z","source":"chrome","type":"休息视频","url":"http://weibo.com/tv/v/FbkGU6CPr?fid=1034:e081f758e64a902ae77593da4d725fb2","used":true,"who":"lxxself"},{"_id":"59620719421aa90cb4724b9d","createdAt":"2017-07-09T18:36:09.395Z","desc":"20个神奇的科学实验和视觉错觉合辑","publishedAt":"2017-07-10T12:48:49.297Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av12013797/","used":true,"who":"LHF"},{"_id":"595e3f40421aa90cb4724b82","createdAt":"2017-07-06T21:46:40.350Z","desc":"九个神奇的磁力小道具","publishedAt":"2017-07-07T12:14:57.685Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av11702675/","used":true,"who":"LHF"}]
     */


    data class ResultsBean(var _id: String?,
                           var createdAt: String?,
                           var desc: String?,
                           var publishedAt: String?,
                           var source: String?,
                           var type: String?,
                           var url: String?,
                           var isUsed: Boolean,
                           var who: String?) {
        /**
         * _id : 596f5ca8421aa90c9203d3c3
         * createdAt : 2017-07-19T21:20:40.76Z
         * desc : 机场里建森林，投资1200亿，有40米高瀑布，搞的一堆人忘了上飞机
         * publishedAt : 2017-07-20T15:11:16.10Z
         * source : chrome
         * type : 休息视频
         * url : http://www.bilibili.com/video/av12360684/
         * used : true
         * who : LHF
         */


    }
}
