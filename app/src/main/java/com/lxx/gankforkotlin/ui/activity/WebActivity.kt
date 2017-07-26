package com.lxx.gankforkotlin.ui.activity

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.lxx.gankforkotlin.R
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {


    var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        url = intent.getStringExtra("url")

        initView()

        tool_bar_web.setNavigationOnClickListener { finish() }

    }

    private fun initView() {
        val settings = web_view.settings
        settings.javaScriptEnabled = true
        web_view.webChromeClient = object : WebChromeClient() {

            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                progress_bar_web.progress = newProgress
            }

            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)
                tool_bar_web.title = title
            }
        }

        web_view.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progress_bar_web.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progress_bar_web.visibility = View.GONE
            }

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }
        }

        web_view.loadUrl(url)

    }

    override fun onDestroy() {
        web_view.removeAllViews()  //销毁 webView  防止内存泄露
        web_view.destroy()
        super.onDestroy()
    }

}
