package com.mayisheng.wanandroid.module.web

import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.BindingAdapter


object WebBindingAdapter {


    @BindingAdapter(value = ["webViewClient", "webChromeClient"])
    @JvmStatic
    fun setSetting(
        webView: WebView,
        viewClient: WebViewClient,
        chromeClient: WebChromeClient
    ) {
        webView.apply {
            webViewClient = viewClient
            webChromeClient = chromeClient
            settings.apply {
                javaScriptEnabled = true
                layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
                loadWithOverviewMode = true
            }
        }
    }

    @BindingAdapter(value = ["loadWebUrl"])
    @JvmStatic
    fun loadWebUrl(webView: WebView, url: String?) {
        url?.let {
            webView.loadUrl(it)
        }
    }
}