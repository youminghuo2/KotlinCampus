package com.example.base.base

import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.base.anno.FragmentConfiguration

/**
 * @Description:
 * @CreateDate: 2021/12/6 15:14
 */
open class BaseFragment: Fragment() {
    companion object {
        private const val TAG = "当前的fragment:"
    }

    private var userEventBus=false

    init {
        this.javaClass.getAnnotation(FragmentConfiguration::class.java)?.let {
            userEventBus=it.useEventBus
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, javaClass.simpleName)
    }

}