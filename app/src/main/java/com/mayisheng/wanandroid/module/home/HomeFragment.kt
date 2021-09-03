package com.mayisheng.wanandroid.module.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import cn.bingoogolapple.bgabanner.BGABanner
import com.mayisheng.wanandroid.BR
import com.mayisheng.wanandroid.R
import com.mayisheng.wanandroid.base.BaseFragment
import com.mayisheng.wanandroid.base.DataBindingConfig
import com.mayisheng.wanandroid.common.loadImage

class HomeFragment : BaseFragment() {
    private lateinit var mState: HomeViewModel
    private val mBannerAdapter: BGABanner.Adapter<ImageView?, String> by lazy {
        BGABanner.Adapter<ImageView?, String> { banner, itemView, model, position ->
            itemView?.apply {
                scaleType = ImageView.ScaleType.CENTER_CROP
                loadImage(mActivity, model)
            }
        }
    }

    private val mBannerDelegate: BGABanner.Delegate<ImageView?, String> by lazy {
        BGABanner.Delegate { banner, itemView, model, position ->

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mState.getBanner()
        mState.getArticles()
        return super.onCreateView(inflater, container, savedInstanceState)

    }
}