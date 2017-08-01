package com.lxx.gankforkotlin.ui.activity

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.Message
import android.os.PersistableBundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.lxx.gankforkotlin.R
import com.lxx.gankforkotlin.ui.fragment.AndroidFragment
import com.lxx.gankforkotlin.ui.fragment.GirlFragment
import com.lxx.gankforkotlin.ui.fragment.VideoFragment
import com.lxx.sdklibrary.ServiceRun
import com.tt.lvruheng.eyepetizer.utils.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mExitTime: Long = 0
    private var androidFragment: AndroidFragment? = null
    private var girlFragment: GirlFragment? = null
    private var videoFragment: VideoFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // mTextMessage = findViewById(R.id.message) as TextView
        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        initFragment()
        initView()

        tv_menu.setOnClickListener { startActivity(Intent(MainActivity@ this, ViewPagerActivity::class.java)) }


        var serviceRun = ServiceRun.getInstance(this)
        var thread = Thread(serviceRun)

        thread.start()

        var msg = Message()
        msg.what = 1
        msg.obj = "来自家里的问候"
        //   serviceRun.handler.sendMessage(msg)

    }

    private fun initView() {
        tv_title.text = "安卓"
    }

    private fun initFragment() {
        androidFragment = AndroidFragment()
        girlFragment = GirlFragment()
        videoFragment = VideoFragment()

        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.add(R.id.content, androidFragment)
        fragmentTrans.add(R.id.content, girlFragment)
        fragmentTrans.add(R.id.content, videoFragment)
        fragmentTrans.commit()

        supportFragmentManager.beginTransaction().show(androidFragment)
                .hide(girlFragment)
                .hide(videoFragment)
                .commit()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_android -> {

                tv_title.text = "安卓"

                supportFragmentManager.beginTransaction().show(androidFragment)
                        .hide(girlFragment)
                        .hide(videoFragment)
                        .commit()

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_girl -> {
                tv_title.text = "妹子"
                supportFragmentManager.beginTransaction().show(girlFragment)
                        .hide(androidFragment)
                        .hide(videoFragment)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_video -> {
                tv_title.text = "休息视频"
                supportFragmentManager.beginTransaction().show(videoFragment)
                        .hide(androidFragment)
                        .hide(girlFragment)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onMultiWindowModeChanged(isInMultiWindowMode: Boolean, newConfig: Configuration?) {
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig)
        Log.e("MainActivity", "onMultiWindowModeChanged")
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.e("MainActivity", "onRestoreInstanceState")
    }


    override fun onBackPressed() {
        if (System.currentTimeMillis().minus(mExitTime) <= 3000) {
            finish()
        } else {
            mExitTime = System.currentTimeMillis()
            showToast("再按一次退出程序")
        }
    }
}
