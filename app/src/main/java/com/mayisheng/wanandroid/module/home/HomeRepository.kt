package com.mayisheng.wanandroid.module.home

import com.mayisheng.wanandroid.base.BaseRepository
import com.mayisheng.wanandroid.http.ApiService
import com.mayisheng.wanandroid.http.RetrofitManager

class HomeRepository : BaseRepository() {
    suspend fun getBanner() = withIO {
        RetrofitManager.getService(ApiService::class.java)
            .getBanner()
            .data()
    }

}