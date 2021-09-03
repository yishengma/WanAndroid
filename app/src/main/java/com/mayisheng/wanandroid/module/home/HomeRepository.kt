package com.mayisheng.wanandroid.module.home

import com.mayisheng.wanandroid.base.BaseRepository
import com.mayisheng.wanandroid.bean.ArticleBean
import com.mayisheng.wanandroid.http.ApiService
import com.mayisheng.wanandroid.http.RetrofitManager

class HomeRepository : BaseRepository() {
    private var page = 0

    suspend fun getBanner() = withIO {
        RetrofitManager.getService(ApiService::class.java)
            .getBanner()
            .data()
    }

    /**
     * 获取置顶文章
     */
    suspend fun getTopArticles() = withIO {
        //请求置顶
        RetrofitManager.getService(ApiService::class.java)
            .getTopList()
            .data()
            .let {
                //对模型转换
                ArticleBean.trans(it)
            }
    }

    /**
     * 请求第一页
     */
    suspend fun getArticles() = withIO {
        page = 0
        RetrofitManager.getService(ApiService::class.java)
            .getHomeList(page)
            .data()
            .datas?.let {
                ArticleBean.trans(it)
            } ?: mutableListOf()
    }


}