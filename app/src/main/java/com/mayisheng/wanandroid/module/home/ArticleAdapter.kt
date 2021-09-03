package com.mayisheng.wanandroid.module.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mayisheng.wanandroid.R
import com.mayisheng.wanandroid.bean.ArticleBean
import com.mayisheng.wanandroid.common.clickNoRepeat
import com.mayisheng.wanandroid.common.getArticleDiff
import com.mayisheng.wanandroid.databinding.ItemHomeArticleBinding
import com.mayisheng.wanandroid.databinding.ItemProjectBinding

class ArticleAdapter(private val context: Context) :
    ListAdapter<ArticleBean, RecyclerView.ViewHolder>(getArticleDiff()) {

    private var mOnItemClickListener: ((Int, View) -> Unit)? = null
    private var mOnItemChildViewClickListener: ((Int, View) -> Unit)? = null

    fun setOnItemClickListener(listener: ((Int, View) -> Unit)? = null) {
        mOnItemClickListener = listener
    }

    fun setOnItemChildViewClickListener(listener: ((Int, View) -> Unit)? = null) {
        mOnItemChildViewClickListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 10) {
            val binding: ItemHomeArticleBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.item_home_article,
                parent,
                false
            )
            ArticleViewHolder(binding.root)
        } else {
            val binding: ItemProjectBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.item_project,
                parent,
                false
            )
            ArticlePicViewHolder(binding.root)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = if (holder is ArticleViewHolder) {
            //获取ViewDataBinding
            DataBindingUtil.getBinding<ItemHomeArticleBinding>(holder.itemView)?.apply {
                dataBean = getItem(position)
            }
        } else {
            DataBindingUtil.getBinding<ItemProjectBinding>(holder.itemView)?.apply {
                dataBean = getItem(position)
            }
        }
        if (binding is ItemHomeArticleBinding) {
            binding.imvCollect.clickNoRepeat {
                mOnItemChildViewClickListener?.invoke(position, it)
            }
        }
        if (binding is ItemProjectBinding) {
            binding.imvCollect.clickNoRepeat {
                mOnItemChildViewClickListener?.invoke(position, it)
            }
        }
        binding?.executePendingBindings()
    }

    override fun submitList(list: List<ArticleBean>?) {
        super.submitList(if (list == null) mutableListOf() else
            mutableListOf<ArticleBean>().apply {
                addAll(
                    list
                )
            })
    }

    /**
     * 默认viewHolder
     */
    class ArticleViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

    }

    /**
     * 带图片viewHolder
     */
    class ArticlePicViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

    }

    override fun getItemViewType(position: Int): Int {
        return if (currentList[position].itemType == 10){
            //普通类型
            10
        }else{
            //带图片类型
            20
        }
    }
}