package com.example.kotlincampus.net

import okhttp3.OkHttpClient

/**
 * @Description:
 * @CreateDate: 2021/12/3 11:27
 */
object RetrofitClient : RetrofitManager() {
    val service by lazy { getService(ApiService::class.java,ApiService.BASE_URL) }

    override fun handleBuilder(builder: OkHttpClient.Builder) = Unit
}