package com.example.kotlincampus.repository

import com.example.kotlincampus.entity.BannerEntity
import com.example.kotlincampus.net.RetrofitClient
import com.example.network.base.BaseRepository
import com.example.network.entity.ApiResponse

/**
 * @Description:
 * @CreateDate: 2021/12/10 16:32
 */
class HomeRepository : BaseRepository() {

    private val mService by lazy {
        RetrofitClient.service
    }

    suspend fun getBannerList(type: String): ApiResponse<List<BannerEntity>> {
        return executeHttp {
            mService.getBannerList(type)
        }
    }
}