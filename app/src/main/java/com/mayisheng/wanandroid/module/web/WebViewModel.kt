package com.mayisheng.wanandroid.module.web


import androidx.lifecycle.MutableLiveData
import com.mayisheng.wanandroid.base.BaseViewModel

class WebViewModel : BaseViewModel() {
    val progress = MutableLiveData<Int>()
    val maxProgress = MutableLiveData<Int>(100)
    val isVisible = MutableLiveData<Boolean>()
    val url = MutableLiveData<String>()
    val title = MutableLiveData<String>()

}