package com.mayisheng.wanandroid.common

import android.content.ClipboardManager
import android.content.Context
import android.content.res.TypedArray
import android.os.Build
import android.os.Parcelable
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.scwang.smartrefresh.layout.SmartRefreshLayout



/**
 * 防止重复点击,可同时注册多个view
 */
fun setNoRepeatClick(vararg views: View, interval: Long = 400, onClick: (View) -> Unit) {
    views.forEach {
        it.clickNoRepeat(interval = interval) { view ->
            onClick.invoke(view)
        }
    }
}

/**
 * 防止重复点击
 * @param interval 重复间隔
 * @param onClick  事件响应
 */
var lastTime = 0L
fun View.clickNoRepeat(interval: Long = 400, onClick: (View) -> Unit) {
    setOnClickListener {
        val currentTime = System.currentTimeMillis()
        if (lastTime != 0L && (currentTime - lastTime < interval)) {
            return@setOnClickListener
        }
        lastTime = currentTime
        onClick(it)
    }
}

/**
 * 复制剪切板
 */
fun copy(context: Context, msg: String) {
    val clip = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    clip.text = msg
}

/**
 * 隐藏刷新加载ui
 */
fun SmartRefreshLayout.smartDismiss() {
    finishRefresh(0)
    finishLoadMore(0)
}

/**
 * 配置SmartRefreshLayout
 */
fun SmartRefreshLayout.smartConfig() {
    //加载
    setEnableLoadMore(true)
    //刷新
    setEnableRefresh(true)
    //不满一页关闭加载
    //setEnableLoadMoreWhenContentNotFull(false)
    //滚动回弹
    setEnableOverScrollDrag(true)
}

/**
 * 获取当前主图颜色属性
 */
fun Context.getThemeColor(attr: Int): Int {
    val array: TypedArray = theme.obtainStyledAttributes(
        intArrayOf(
            attr
        )
    )
    val color = array.getColor(0, -0x50506)
    array.recycle()
    return color
}


/**
 * editText搜索按钮
 * @param onClick 搜索点击事件
 */
fun EditText.keyBoardSearch(onClick: () -> Unit) {
    //添加搜索按钮
    setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            onClick()
        } else {
            return@setOnEditorActionListener false
        }
        return@setOnEditorActionListener true
    }
}





