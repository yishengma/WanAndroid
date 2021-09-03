package com.mayisheng.wanandroid.base.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.mayisheng.wanandroid.bean.ArticleBean
import com.mayisheng.wanandroid.bean.BannerBean
import com.mayisheng.wanandroid.module.home.ArticleAdapter

object RecyclerViewBindingAdapter {
    @BindingAdapter(value = ["listAdapter"])
    @JvmStatic
    fun setAdapter(
        recyclerView: RecyclerView,
        listAdapter: ArticleAdapter
    ) {
        recyclerView.adapter = listAdapter
    }


    @BindingAdapter(value = ["submitList"], requireAll = false)
    @JvmStatic
    fun submitList(
        recyclerView: RecyclerView,
        list: MutableLiveData<List<ArticleBean>>
    ) {
        if (recyclerView.adapter != null && list.value != null) {
            val adapter = recyclerView.adapter as ArticleAdapter
            adapter.submitList(list.value)
        }
    }
}