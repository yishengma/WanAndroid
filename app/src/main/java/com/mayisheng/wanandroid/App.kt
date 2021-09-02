package com.mayisheng.wanandroid

import android.app.Application
import android.content.Context
import com.mayisheng.wanandroid.base.BaseApplication

class App : BaseApplication() {
    @Override
    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        private lateinit var context: Application

        fun getContext(): Context {
            return context
        }
    }

}