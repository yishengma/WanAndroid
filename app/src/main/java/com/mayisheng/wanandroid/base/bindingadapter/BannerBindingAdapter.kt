package com.mayisheng.wanandroid.base.bindingadapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import cn.bingoogolapple.bgabanner.BGABanner
import com.mayisheng.wanandroid.R
import com.mayisheng.wanandroid.bean.BannerBean

object BannerBindingAdapter {

    @BindingAdapter(value = ["autoPlayAble", "adapter", "delegate", "data"], requireAll = false)
    @JvmStatic
    fun bindBanner(
        banner: BGABanner,
        enable: Boolean,
        adapter: BGABanner.Adapter<ImageView, String>,
        delegate: BGABanner.Delegate<ImageView, String>,
        data: MutableLiveData<List<BannerBean>>
    ) {
        banner.apply {
            setAutoPlayAble(enable)
            val views: MutableList<View> = ArrayList()
            val strings: MutableList<String> = ArrayList()

            data.value?.forEach {
                views.add(ImageView(banner.context).apply {
                    setBackgroundResource(R.drawable.ripple_bg)
                })
                strings.add(
                    if (it.imagePath.isNullOrEmpty()) {
                        ""
                    } else {
                        it.imagePath!!
                    }
                )
            }
            setAdapter(adapter)
            setDelegate(delegate)
            setData(views, strings, null)
        }

    }

}