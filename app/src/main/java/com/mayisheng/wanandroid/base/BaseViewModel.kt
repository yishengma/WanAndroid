package com.mayisheng.wanandroid.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

private const val TAG = "BaseViewModel"

open class BaseViewModel : ViewModel() {
    protected fun <T> launch(block: suspend () -> T) {
        viewModelScope.launch {
            runCatching {
                block()
            }.onFailure {
                Log.e(TAG, it.message!!)
            }
        }
    }
}