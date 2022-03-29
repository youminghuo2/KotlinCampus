package com.example.kotlincampus.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kotlincampus.entity.Repo
import java.lang.Exception

/**
 * @Author: zcy
 * @CreateDate: 2022/3/29 15:26
 * @Description:
 */
class RepoPagingSource(val gitHubService: GitHubService):PagingSource<Int,Repo>() {
  override suspend fun load(params: PagingSource.LoadParams<Int>):PagingSource.LoadResult<Int,Repo> {
     return try {
          val page = params.key ?: 1
          val pageSize = params.loadSize
          val repoResponse = gitHubService.searchRepos(page, pageSize)
          val repoItems = repoResponse.items
          val prevKey = if (page > 1) page - 1 else null
          val nextKey = if (repoItems.isNotEmpty()) page + 1 else null
          LoadResult.Page(repoItems, prevKey, nextKey)
      } catch (e: Exception) {
          LoadResult.Error(e)
      }
  }

    override fun getRefreshKey(state: PagingState<Int, Repo>): Int?=null
}