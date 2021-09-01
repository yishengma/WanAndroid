package com.mayisheng.wanandroid.base

import android.util.SparseArray
import androidx.lifecycle.ViewModel

class DataBindingConfig constructor(
    private val mLayout: Int,
    private val mVmVariable: Int,
    private val mStateViewModel: ViewModel
) {

    private var mBindingParams: SparseArray<Any> = SparseArray()

    fun addBindingParam(variableId: Int, obj: Any): DataBindingConfig {
        if (mBindingParams.get(variableId) == null) {
            mBindingParams.put(variableId, obj)
        }
        return this
    }

    fun getLayout(): Int {
        return mLayout
    }

    fun getVmVariable(): Int {
        return mVmVariable
    }

    fun getStateViewModel(): ViewModel {
        return mStateViewModel
    }

    fun getBindingParams(): SparseArray<Any> {
        return mBindingParams
    }

}