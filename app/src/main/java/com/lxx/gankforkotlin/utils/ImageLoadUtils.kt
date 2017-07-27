package com.tt.lvruheng.eyepetizer.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.lxx.gankforkotlin.R

/**
 * Created by lvruheng on 2017/7/6.
 */
class ImageLoadUtils {
    companion object {
        fun display(context: Context, imageView: ImageView?, url: String) {
            if (imageView == null) {
                throw IllegalArgumentException("argument error")
            }
            Glide.with(context).load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .crossFade().into(imageView)
        }

        fun displayHigh(context: Context, imageView: ImageView?, url: String) {
            if (imageView == null) {
                throw IllegalArgumentException("argument error")
            }
            Glide.with(context).load(url)
                    // .asBitmap()
                    // .format(DecodeFormat.PREFER_ARGB_8888)
                    // .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    // .placeholder(R.drawable.ic_image_loading)
                    // .error(R.drawable.ic_empty_picture)
                    .into(imageView)
        }


        fun display2(context: Context, imageView: ImageView?, url: String) {
            if (imageView == null) {
                throw IllegalArgumentException("argument error")
            }
            Glide.with(context).load(url)
                    .centerCrop()
                    .into(imageView)
        }

    }

}