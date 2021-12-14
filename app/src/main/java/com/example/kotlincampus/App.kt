package com.example.kotlincampus

import android.annotation.SuppressLint
import android.content.Context
import com.example.base.base.BaseApp

/**
 * @Description:
 * @CreateDate: 2021/12/6 15:34
 */
class App : BaseApp() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context=applicationContext
    }
}