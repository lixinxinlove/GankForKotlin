package com.lxx.baselibrary.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lxx.baselibrary.R
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        tv.text = "lixinxin"
    }
}
