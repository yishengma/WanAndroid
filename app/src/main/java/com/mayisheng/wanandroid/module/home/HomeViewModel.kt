package com.mayisheng.wanandroid.module.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mayisheng.wanandroid.base.BaseViewModel
import com.mayisheng.wanandroid.bean.ArticleBean
import com.mayisheng.wanandroid.bean.BannerBean
import kotlinx.coroutines.async

class HomeViewModel : BaseViewModel() {
    private val mHomeRepository: HomeRepository by lazy { HomeRepository() }
    val banner: MutableLiveData<List<BannerBean>> = MutableLiveData<List<BannerBean>>()
    val articles: MutableLiveData<List<ArticleBean>> = MutableLiveData<List<ArticleBean>>()


    fun getBanner() {
        launch {
            banner.value = mHomeRepository.getBanner()
        }
    }

    fun getArticles() {
        launch {
            val list = mutableListOf<ArticleBean>()
            val articles = viewModelScope.async {
                mHomeRepository.getArticles()
            }
            val topArticle = viewModelScope.async {
                mHomeRepository.getTopArticles()
            }
            list.addAll(topArticle.await())
            list.addAll(articles.await())
            this.articles.value = list
        }
    }

}