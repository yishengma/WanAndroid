package com.mayisheng.wanandroid.module.main

import androidx.fragment.app.FragmentActivity
import com.mayisheng.wanandroid.BR
import com.mayisheng.wanandroid.R
import com.mayisheng.wanandroid.base.BaseFragment
import com.mayisheng.wanandroid.base.DataBindingConfig

class MainFragment : BaseFragment() {
    private lateinit var mState: MainViewModel

    override fun initViewModel() {
        mState = getFragmentScopeViewModel(MainViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_main, BR.viewModel, mState)
            .addBindingParam(BR.fragmentActivity, mActivity as FragmentActivity)
    }

}