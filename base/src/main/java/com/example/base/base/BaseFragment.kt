package com.example.base.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.base.anno.FragmentConfiguration

/**
 * @Description:
 * @CreateDate: 2021/12/6 15:14
 */
class BaseFragment: Fragment() {
    private var userEventBus=false
    init {
        this.javaClass.getAnnotation(FragmentConfiguration::class.java)?.let {
            userEventBus=it.useEventBus
        }
    }
}