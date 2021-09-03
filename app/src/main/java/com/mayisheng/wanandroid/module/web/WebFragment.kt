package com.mayisheng.wanandroid.module.web

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.mayisheng.wanandroid.BR
import com.mayisheng.wanandroid.R
import com.mayisheng.wanandroid.base.BaseFragment
import com.mayisheng.wanandroid.base.DataBindingConfig

class WebFragment : BaseFragment() {

    private lateinit var mState: WebViewModel
    private var webViewClient = object : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            //返回false，意味着请求过程里，不管有多少次的跳转请求（即新的请求地址）
            //均交给webView自己处理，这也是此方法的默认处理
            return false
        }

        override fun shouldOverrideUrlLoading(
            view: WebView,
            request: WebResourceRequest
        ): Boolean {
            //返回false，意味着请求过程里，不管有多少次的跳转请求（即新的请求地址）
            //均交给webView自己处理，这也是此方法的默认处理
            return false
        }
    }

    private var webChromeClient = object : WebChromeClient() {
        override fun onProgressChanged(view: WebView, newProgress: Int) {
            super.onProgressChanged(view, newProgress)

            mState.isVisible.value = !(newProgress == 100)

            //改变进度
            mState.progress.value = newProgress
        }
    }

    private var backClickListener = View.OnClickListener {
        nav().navigateUp()
    }


    override fun initViewModel() {
        mState = getFragmentScopeViewModel(WebViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_web, BR.vm, mState)
            .addBindingParam(BR.viewClient, webViewClient)
            .addBindingParam(BR.chromeClient, webChromeClient)
            .addBindingParam(BR.backClickListener, backClickListener)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            mState.title.value = it["title"] as String
            mState.url.value = it["loadUrl"] as String
        }
    }
}