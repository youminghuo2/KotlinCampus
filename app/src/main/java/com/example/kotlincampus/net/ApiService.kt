package com.example.kotlincampus.net

import com.example.kotlincampus.entity.BannerEntity
import com.example.kotlincampus.entity.LoginEntity
import com.example.kotlincampus.entity.PageListEntity
import com.example.network.entity.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * @Description:
 * @CreateDate: 2021/12/3 13:51
 */
interface ApiService {
    //账号密码登录
    @GET("basicdata/index/login/bypwd")
    suspend fun login(
        @Query("username") username: String,
        @Query("encryptPwd") encryptPwd: String,
        @Query("clientType") clientType: String,
        @Query("clientVersion") clientVersion: String
    ): ApiResponse<LoginEntity?>

    companion object {
        const val BASE_URL = "http://101.133.155.220:18080/"
    }

    @GET("portal/index/poster/list/bylocation")
    suspend fun getBannerList(@Query("location") locations: String): ApiResponse<List<BannerEntity>>

    @GET("cms/index/ysyx/appindex/postslist")
    suspend fun getPageList(@Header("Auth-JWT") token:String, @Query("pageNum") pageNum: Int, @Query("pageSize") pageSize: Int):ApiResponse<PageListEntity>
}