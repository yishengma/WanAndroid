package com.mayisheng.wanandroid.http

import com.mayisheng.wanandroid.bean.ArticleData
import com.mayisheng.wanandroid.bean.ArticleList
import com.mayisheng.wanandroid.bean.BannerBean
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    /**
     * 获取首页文章数据
     */
    @GET("/article/list/{page}/json")
    suspend fun getHomeList(@Path("page") pageNo: Int): ApiResponse<ArticleList>

    /**
     * 获取首页置顶文章数据
     */
    @GET("/article/top/json")
    suspend fun getTopList(): ApiResponse<MutableList<ArticleData>>

    /**
     * banner
     */
    @GET("/banner/json")
    suspend fun getBanner(): ApiResponse<MutableList<BannerBean>>
}