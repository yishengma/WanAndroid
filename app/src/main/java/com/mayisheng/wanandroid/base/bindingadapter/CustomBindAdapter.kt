package com.mayisheng.wanandroid.base.bindingadapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.mayisheng.wanandroid.common.loadImage
import com.mayisheng.wanandroid.common.loadCircle
import com.mayisheng.wanandroid.common.loadRadius


object CustomBindAdapter {



    /**
     * 加载资源图片
     */
    @BindingAdapter(value = ["imgSrc"])
    @JvmStatic
    fun imgSrc(view: ImageView, id: Int) {
        view.setImageResource(id)
    }

    /**
     * 加载图片
     */
    @BindingAdapter(value = ["imageUrl"])
    @JvmStatic
    fun imageUrl(view: ImageView, url: String) {
        view.loadImage(view.context.applicationContext,url)
    }


    /**
     * 加载网络圆角图片
     */
    @BindingAdapter(value = ["imgUrlRadius"])
    @JvmStatic
    fun imgUrlRadiusCircle(view: ImageView, url: String) {
        view.loadRadius(view.context.applicationContext, url)
    }



    @BindingAdapter(value = ["visible"])
    @JvmStatic
    fun visible(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

}