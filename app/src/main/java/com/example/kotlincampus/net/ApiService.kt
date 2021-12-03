package com.example.kotlincampus.net

import com.example.kotlincampus.entity.LoginEntity
import com.example.network.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Header
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
    ):ApiResponse<LoginEntity>
}