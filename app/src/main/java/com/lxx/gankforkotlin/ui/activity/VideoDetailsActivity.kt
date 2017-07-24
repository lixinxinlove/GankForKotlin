package com.lxx.gankforkotlin.ui.activity

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.MediaController
import com.lxx.gankforkotlin.R
import com.lxx.gankforkotlin.mvp.contract.VideoDetailsContract
import com.lxx.gankforkotlin.mvp.presenter.VideoDetailsPresenter
import kotlinx.android.synthetic.main.activity_video_details.*

/**
 * 视频播放
 */

class VideoDetailsActivity : AppCompatActivity(), VideoDetailsContract.View {

    var url: String? = null

    private var mPresenter: VideoDetailsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_details)
        url = intent.getStringExtra("url")
        init()
    }

    private fun init() {
        mPresenter = VideoDetailsPresenter(this, this)
        mPresenter?.getUrl(url!!)
    }

    override fun setData(url: String) {
        video_view.setMediaController(MediaController(this))
        // 播放在线视频
        var mVideoUri = Uri.parse(url)
        // video_view.setVideoURI(mVideoUri)
        video_view.setVideoPath(mVideoUri.toString())
        video_view.start()
        video_view.requestFocus()
    }

    override fun showRefresh() {
    }

    override fun showError() {
    }


}


