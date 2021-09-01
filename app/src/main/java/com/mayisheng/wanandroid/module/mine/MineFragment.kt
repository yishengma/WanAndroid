package com.mayisheng.wanandroid.module.mine

import com.mayisheng.wanandroid.BR
import com.mayisheng.wanandroid.R
import com.mayisheng.wanandroid.base.BaseFragment
import com.mayisheng.wanandroid.base.DataBindingConfig
import com.mayisheng.wanandroid.module.home.HomeViewModel

class MineFragment:BaseFragment() {
    private lateinit var mState: MineViewModel
    override fun initViewModel() {
        mState = getFragmentScopeViewModel(MineViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_mine, BR.VM, mState)
    }
}