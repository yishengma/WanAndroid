package com.mayisheng.wanandroid.common

import androidx.recyclerview.widget.DiffUtil
import com.mayisheng.wanandroid.bean.ArticleBean

fun getArticleDiff(): DiffUtil.ItemCallback<ArticleBean> {
    return object : DiffUtil.ItemCallback<ArticleBean>() {
        override fun areItemsTheSame(oldItem: ArticleBean, newItem: ArticleBean): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ArticleBean, newItem: ArticleBean): Boolean {
            return oldItem.collect == newItem.collect
                    && oldItem.date == newItem.date
        }
    }

}