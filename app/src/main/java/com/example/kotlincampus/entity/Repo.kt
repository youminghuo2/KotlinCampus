package com.example.kotlincampus.entity

import com.google.gson.annotations.SerializedName

/**
 * @Author: zcy
 * @CreateDate: 2022/3/29 15:19
 * @Description:
 */
data class Repo(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String?,
    @SerializedName("stargazers_count") val starCount: Int
)