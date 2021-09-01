package com.mayisheng.wanandroid.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity : DataBindingActivity() {
    private val mActivityProvider: ViewModelProvider by lazy { ViewModelProvider(this) }
    private val mApplicationProvider: ViewModelProvider by lazy { ViewModelProvider(this.applicationContext as BaseApplication) }

    protected fun <T : ViewModel> getActivityScopeViewModel(clazz: Class<T>): T {
        return mActivityProvider.get(clazz)
    }

    protected fun <T : ViewModel> getApplicationScopeViewModel(clazz: Class<T>): T {
        return mApplicationProvider.get(clazz)
    }

}