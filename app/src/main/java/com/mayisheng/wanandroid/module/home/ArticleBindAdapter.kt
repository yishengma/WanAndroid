package com.mayisheng.wanandroid.module.home

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.mayisheng.wanandroid.R

object ArticleBindAdapter {

    /**
     * 加载图片,做高斯模糊处理
     */
    @BindingAdapter(value = ["articleCollect"])
    @JvmStatic
    fun imgPlayBlur(view: ImageView, collect: Boolean) {
        if (collect) {
            view.setImageResource(R.drawable._collect)
        } else {
            view.setImageResource(R.drawable.un_collect)
        }
    }

}