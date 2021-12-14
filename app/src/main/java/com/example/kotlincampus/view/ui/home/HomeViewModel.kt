package com.example.kotlincampus.view.ui.home

import androidx.lifecycle.ViewModel
import com.example.kotlincampus.entity.BannerEntity
import com.example.kotlincampus.entity.PageListEntity
import com.example.kotlincampus.repository.HomeRepository
import com.example.network.StateMutableLiveData
import com.example.network.entity.ApiResponse

class HomeViewModel : ViewModel() {
    private val repository by lazy { HomeRepository() }

    val pageLiveData = StateMutableLiveData<PageListEntity>()

    suspend fun getBannerList(type: String): ApiResponse<List<BannerEntity>> {
        return repository.getBannerList(type)
    }

    suspend fun getPageList(pageNum:Int, pageSize: Int) {
        pageLiveData.value =repository.getPageList(pageNum, pageSize)
    }

}