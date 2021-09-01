package com.mayisheng.wanandroid.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.forEach
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class DataBindingActivity : AppCompatActivity() {
    private lateinit var mBinding: ViewDataBinding

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        val bindingConfig = getDataBindingConfig()
        val binding =
            DataBindingUtil.setContentView<ViewDataBinding>(this, bindingConfig.getLayout())
        binding.lifecycleOwner = this
        binding.setVariable(bindingConfig.getVmVariable(), bindingConfig.getStateViewModel())
        val bindingParams = bindingConfig.getBindingParams()
        bindingParams.forEach { key, value ->
            binding.setVariable(key, value)
        }
        mBinding = binding
    }

    @Override
    override fun onDestroy() {
        super.onDestroy()
        mBinding.unbind()
    }

    protected fun getBinding(): ViewDataBinding {
        throw IllegalAccessException("you can't get ViewDataBinding instance,cause it is not suggested!")
    }

    protected abstract fun initViewModel()

    protected abstract fun getDataBindingConfig(): DataBindingConfig


}