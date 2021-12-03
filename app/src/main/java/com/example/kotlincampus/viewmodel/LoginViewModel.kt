package com.example.kotlincampus.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kotlincampus.entity.LoginEntity
import com.example.kotlincampus.view.LoginRepository
import com.example.network.ApiResponse

/**
 * @Description:
 * @CreateDate: 2021/12/3 14:32
 */
class LoginViewModel : ViewModel() {
    private val repository by lazy { LoginRepository() }

    suspend fun login(username: String, password: String,clientType:String,clientVersion:String): ApiResponse<LoginEntity> {
        return repository.login(username, password,clientType,clientVersion)
    }
}