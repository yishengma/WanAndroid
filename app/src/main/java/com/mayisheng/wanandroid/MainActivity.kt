package com.mayisheng.wanandroid

import android.os.Bundle
import com.mayisheng.wanandroid.base.BaseActivity
import com.mayisheng.wanandroid.base.DataBindingConfig

class MainActivity : BaseActivity() {
    private lateinit var mState: MainActivityViewModel
    private lateinit var mEvent: ShareViewModel

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initViewModel() {
        mEvent = getApplicationScopeViewModel(ShareViewModel::class.java)
        mState = getActivityScopeViewModel(MainActivityViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.activity_main, BR.viewModel, mState)
    }

}