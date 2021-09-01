package com.mayisheng.wanandroid.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.forEach
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class DataBindingFragment : Fragment() {
    protected lateinit var mActivity: AppCompatActivity
    private var mBinding: ViewDataBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.initViewModel()
    }

    @Override
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindingConfig = getDataBindingConfig()
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            bindingConfig.getLayout(),
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(bindingConfig.getVmVariable(), bindingConfig.getStateViewModel())
        val bindingParams = bindingConfig.getBindingParams()
        bindingParams.forEach { key, value ->
            binding.setVariable(key, value)
        }
        mBinding = binding
        return binding.root
    }

    @Override
    override fun onDestroyView() {
        super.onDestroyView()
        mBinding?.unbind()
        mBinding = null//must set null!
    }

    protected abstract fun initViewModel()

    protected abstract fun getDataBindingConfig(): DataBindingConfig

    protected fun getBinding(): ViewDataBinding {
        throw IllegalAccessException("you can't get ViewDataBinding instance,cause it is not suggested!")
    }

}