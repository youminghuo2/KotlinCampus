package com.example.kotlincampus.net

import android.text.TextUtils
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.kotlincampus.App.Companion.context
import com.example.kotlincampus.utils.dataStore
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


/**
 * @Description:添加拦截器，利用DataStore存储token
 * @CreateDate: 2021/12/14 14:02
 */
class HeaderInterceptor : Interceptor {
    private val key = stringPreferencesKey(Constants.token_key)
    private val refreshKey = stringPreferencesKey(Constants.refresh_token)

    override fun intercept(chain: Interceptor.Chain): Response {

        val exampleCounterFlow: Flow<String> = context.dataStore.data
            .map { preferences ->
                preferences[key] ?: ""
            }

        val originalRequest: Request = chain.request()
        val response = chain.proceed(originalRequest)

        val responseToken = response.headers["auth-jwt"].toString()
        val refreshToken = response.headers["auth-jwt-refresh"].toString()

        MainScope().launch {
            val tokeData = exampleCounterFlow.first()

            if (TextUtils.isEmpty(tokeData) && !TextUtils.isEmpty(responseToken)) {
                setDataToken(responseToken, refreshToken)
            }
        }

        return response
    }

    private suspend fun setDataToken(token: String, refreshToken: String) {
        context.dataStore.edit { settings ->
            settings[key] = token
            settings[refreshKey] = refreshToken
        }
    }

}