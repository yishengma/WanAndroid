package com.mayisheng.wanandroid.module.square

import com.mayisheng.wanandroid.BR
import com.mayisheng.wanandroid.R
import com.mayisheng.wanandroid.base.BaseFragment
import com.mayisheng.wanandroid.base.DataBindingConfig
import com.mayisheng.wanandroid.module.project.ProjectViewModel

class SquareFragment : BaseFragment() {
    private lateinit var mState: SquareViewModel
    override fun initViewModel() {
        mState = getFragmentScopeViewModel(SquareViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_square, BR.VM, mState)
    }
}