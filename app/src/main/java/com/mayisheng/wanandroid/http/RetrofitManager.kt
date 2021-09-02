package com.mayisheng.wanandroid.http

class RetrofitManager {
    companion object {
        private val mMap = mutableMapOf<Class<*>, Any>()
        private val mRetrofit = RetrofitFactory.factory()


         fun <T : Any> getService(apiClass: Class<T>): T {
            return if (mMap[apiClass] == null) {
                synchronized(RetrofitManager::class.java) {
                    val t = mRetrofit.create(apiClass)
                    if (mMap[apiClass] == null) {
                        mMap[apiClass] = t
                    }
                    t
                }
            } else {
                mMap[apiClass] as T
            }
        }
    }
}