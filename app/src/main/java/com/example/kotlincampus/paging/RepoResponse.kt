package com.example.kotlincampus.paging

import com.example.kotlincampus.entity.Repo
import com.google.gson.annotations.SerializedName

/**
 * @Author: zcy
 * @CreateDate: 2022/3/29 15:22
 * @Description:
 */
class RepoResponse {
    @SerializedName("items") val items: List<Repo> = emptyList()
}