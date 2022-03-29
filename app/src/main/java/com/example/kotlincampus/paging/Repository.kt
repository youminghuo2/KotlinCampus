package com.example.kotlincampus.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.kotlincampus.entity.Repo
import kotlinx.coroutines.flow.Flow

/**
 * @Author: zcy
 * @CreateDate: 2022/3/29 15:45
 * @Description:
 */
object Repository {
    private const val PAGE_SIZE=20
    private val gitHubService=GitHubService.create()

    fun getPagingData():Flow<PagingData<Repo>>{
        return Pager(
            config = PagingConfig(PAGE_SIZE),
            pagingSourceFactory = {RepoPagingSource(gitHubService)}
        ).flow
    }

}