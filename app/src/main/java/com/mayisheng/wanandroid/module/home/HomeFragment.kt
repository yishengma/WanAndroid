package com.mayisheng.wanandroid.module.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import cn.bingoogolapple.bgabanner.BGABanner
import com.mayisheng.wanandroid.BR
import com.mayisheng.wanandroid.R
import com.mayisheng.wanandroid.base.BaseFragment
import com.mayisheng.wanandroid.base.DataBindingConfig
import com.mayisheng.wanandroid.bean.BannerBean
import com.mayisheng.wanandroid.common.loadImage

class HomeFragment : BaseFragment() {
    private lateinit var mState: HomeViewModel
    private val mBannerAdapter: BGABanner.Adapter<ImageView?, BannerBean> by lazy {
        BGABanner.Adapter<ImageView?, BannerBean> { banner, itemView, model, position ->
            itemView?.apply {
                scaleType = ImageView.ScaleType.CENTER_CROP
                loadImage(mActivity, model?.imagePath)
            }
        }
    }

    private val mBannerDelegate: BGABanner.Delegate<ImageView?, BannerBean> by lazy {
        BGABanner.Delegate { banner, itemView, model, position ->
            nav().navigate(R.id.web_fragment, Bundle().apply {
                putString("loadUrl", model?.url)
                putString("title", model?.title)
                putInt("id", position)
            })
        }
    }

    private val mAdapter: ArticleAdapter by lazy { ArticleAdapter(mActivity) }


    override fun initViewModel() {
        mState = getFragmentScopeViewModel(HomeViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_home, BR.VM, mState)
            .addBindingParam(BR.adapter, mBannerAdapter)
            .addBindingParam(BR.delegate, mBannerDelegate)
            .addBindingParam(BR.listAdapter, mAdapter)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mState.getBanner()
        mState.getArticles()
    }
}