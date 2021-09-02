package com.mayisheng.wanandroid.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mayisheng.wanandroid.utils.ColorUtils
import com.mayisheng.wanandroid.utils.StatusUtils

abstract class BaseActivity : DataBindingActivity() {
    private val mActivityProvider: ViewModelProvider by lazy { ViewModelProvider(this) }
    private val mApplicationProvider: ViewModelProvider by lazy { ViewModelProvider(this.applicationContext as BaseApplication) }

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    /**
     * 设置状态栏背景颜色
     */
    open fun setStatusColor() {
        StatusUtils.setUseStatusBarColor(this, ColorUtils.parseColor("#00ffffff"))
    }

    /**
     * 沉浸式状态
     */
    open fun setSystemInvadeBlack() {
        //第二个参数是是否沉浸,第三个参数是状态栏字体是否为黑色。
        StatusUtils.setSystemStatus(this, true, true)
    }

    protected fun <T : ViewModel> getActivityScopeViewModel(clazz: Class<T>): T {
        return mActivityProvider.get(clazz)
    }

    protected fun <T : ViewModel> getApplicationScopeViewModel(clazz: Class<T>): T {
        return mApplicationProvider.get(clazz)
    }

}