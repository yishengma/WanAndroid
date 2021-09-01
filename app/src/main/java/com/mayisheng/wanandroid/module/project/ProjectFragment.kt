package com.mayisheng.wanandroid.module.project

import com.mayisheng.wanandroid.BR
import com.mayisheng.wanandroid.R
import com.mayisheng.wanandroid.base.BaseFragment
import com.mayisheng.wanandroid.base.DataBindingConfig
import com.mayisheng.wanandroid.module.mine.MineViewModel

class ProjectFragment : BaseFragment() {
    private lateinit var mState: ProjectViewModel
    override fun initViewModel() {
        mState = getFragmentScopeViewModel(ProjectViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_project, BR.VM, mState)
    }
}