package com.mayisheng.wanandroid.http

import com.zs.base_library.http.ApiException
import java.io.Serializable

class ApiResponse<T> : Serializable {
    private var data: T? = null
    private var errorMsg = ""
    private var errorCode = 0

    fun data(): T {
        when (errorCode) {
            //请求成功
            0, 200 -> {
                return data!!
            }
        }
        //其他错误
        throw ApiException(errorMsg, errorCode)
    }
}