package com.mayisheng.wanandroid.http

import com.mayisheng.wanandroid.App.Companion.getContext
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import java.util.logging.Level

object RetrofitFactory {
    private val okHttpClientBuilder: OkHttpClient.Builder
        get() {
            return OkHttpClient.Builder()
                .readTimeout(10_000L, TimeUnit.MILLISECONDS)
                .connectTimeout(10_000L, TimeUnit.MILLISECONDS)
                .addInterceptor(getLogInterceptor())
                .cache(getCache())
        }

    fun factory(): Retrofit {
        val okHttpClient = okHttpClientBuilder.build()
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.wanandroid.com")
            .build()
    }

    private fun getLogInterceptor(): Interceptor {
        //http log 拦截器
        return HttpLoggingInterceptor("OkHttp").apply {
            setPrintLevel(HttpLoggingInterceptor.Level.BODY)
            setColorLevel(Level.INFO)
        }
    }

    private fun getCache(): Cache {
        //缓存100Mb
        return Cache(
            File(getContext().cacheDir, "cache"), 1024 * 1024 * 100
        )
    }

}