package com.example.base.base

import android.app.Application
import androidx.lifecycle.*

/**
 * @Description:
 * @CreateDate: 2021/12/6 10:49
 */
open class BaseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycleObserver())
    }

    companion object {
        lateinit var instance: BaseApp
            private set
    }


    private inner class ApplicationLifecycleObserver : DefaultLifecycleObserver {
        override fun onCreate(owner: LifecycleOwner) {
            super.onCreate(owner)
        }

        override fun onStart(owner: LifecycleOwner) {
            super.onStart(owner)
        }

        override fun onResume(owner: LifecycleOwner) {
            super.onResume(owner)
        }

        override fun onPause(owner: LifecycleOwner) {
            super.onPause(owner)
        }

        override fun onStop(owner: LifecycleOwner) {
            super.onStop(owner)
        }

        override fun onDestroy(owner: LifecycleOwner) {
            super.onDestroy(owner)
        }
    }
}