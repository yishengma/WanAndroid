package com.mayisheng.wanandroid.bean

import android.text.Html
import android.text.TextUtils

class ArticleBean(
    var id: Int = 0,

    /**
     * 作者
     */
    var author: String? = null,

    /**
     * 是否收藏
     */
    var collect: Boolean = false,

    /**
     * 描述信息
     */
    var desc: String? = null,

    /**
     * 图片类型，有和无
     */
    var picUrl: String? = null,

    /**
     * 链接
     */
    var link: String? = null,

    /**
     * 日期
     */
    var date: String? = null,

    /**
     * 标题
     */
    var title: String? = null,

    /**
     * 文章标签
     */
    var articleTag: String? = null,

    /**
     * 1.置顶
     */
    var topTitle: String? = null
) : MultiItemEntity {


    override fun getItemType(): Int {
        return if (picUrl.isNullOrEmpty()) {
            10
        } else {
            20
        }
    }

    @Override
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    companion object {
        fun trans(dataList: MutableList<ArticleData>): MutableList<ArticleBean> {
            return dataList.map {
                ArticleBean().apply {
                    id = it.id
                    author = if (TextUtils.isEmpty(it.author)) {
                        it.shareUser
                    } else {
                        it.author
                    }
                    collect = it.collect
                    desc = it.desc
                    picUrl = it.envelopePic
                    link = it.link
                    date = it.niceDate
                    title = Html.fromHtml(it.title).toString()
                    articleTag = it.superChapterName
                    topTitle = if (it.type == 1) "置顶" else ""
                }
            }.toMutableList()
        }
    }
}
