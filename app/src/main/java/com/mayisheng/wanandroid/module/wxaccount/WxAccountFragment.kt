package com.mayisheng.wanandroid.module.wxaccount

import com.mayisheng.wanandroid.BR
import com.mayisheng.wanandroid.R
import com.mayisheng.wanandroid.base.BaseFragment
import com.mayisheng.wanandroid.base.DataBindingConfig

class WxAccountFragment : BaseFragment() {
    private lateinit var mState: WxAccountViewModel
    override fun initViewModel() {
        mState = getFragmentScopeViewModel(WxAccountViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_wxaccount, BR.VM, mState)
    }
}