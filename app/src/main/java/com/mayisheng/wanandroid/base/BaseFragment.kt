package com.mayisheng.wanandroid.base

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

abstract class BaseFragment : DataBindingFragment() {
    private val mFragmentProvider: ViewModelProvider by lazy { ViewModelProvider(this) }
    private val mActivityProvider: ViewModelProvider by lazy { ViewModelProvider(mActivity) }
    private val mApplicationProvider: ViewModelProvider by lazy { ViewModelProvider(mActivity.applicationContext as BaseApplication) }


    protected fun <T : ViewModel> getFragmentScopeViewModel(clazz: Class<T>): T {
        return mFragmentProvider.get(clazz)
    }

    protected fun <T : ViewModel> getActivityScopeViewModel(clazz: Class<T>): T {
        return mActivityProvider.get(clazz)
    }

    protected fun <T : ViewModel> getApplicationScopeViewModel(clazz: Class<T>): T {
        return mApplicationProvider.get(clazz)
    }

    protected fun nav(): NavController {
        return NavHostFragment.findNavController(this)
    }

    protected fun getApplicationContext(): Context {
        return mActivity.applicationContext
    }

}