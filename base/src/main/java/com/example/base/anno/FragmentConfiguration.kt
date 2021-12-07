package com.example.base.anno

/**
 * @Description:
 * @CreateDate: 2021/12/6 15:16
 */
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
annotation class FragmentConfiguration(

    val useEventBus: Boolean = false
)