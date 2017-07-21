package com.lxx.gankforkotlin.ui.activity

import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.lxx.gankforkotlin.R
import com.tt.lvruheng.eyepetizer.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.activity_girl_details.*

class GirlDetailsActivity : AppCompatActivity() {

    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_girl_details)

        url = intent.getStringExtra("url")
        ViewCompat.setTransitionName(photo_view, "lee")

        initView()

        ibtn_back.setOnClickListener { finishAfterTransition() }

    }

    private fun initView() {
        ImageLoadUtils.display(this, photo_view, url!!)
    }
}
