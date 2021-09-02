package com.mayisheng.wanandroid.module.home

import androidx.lifecycle.MutableLiveData
import com.mayisheng.wanandroid.base.BaseViewModel
import com.mayisheng.wanandroid.bean.BannerBean

class HomeViewModel : BaseViewModel() {
    private val mHomeRepository: HomeRepository by lazy { HomeRepository() }
    val banner: MutableLiveData<List<BannerBean>> = MutableLiveData<List<BannerBean>>()

    fun getBanner() {
        launch {
            banner.value = mHomeRepository.getBanner()
        }
    }

}