package com.example.base.anno

/**
 * @Description:
 * @CreateDate: 2021/12/6 15:16
 */
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
annotation class ActivityConfiguration(

    val useEventBus: Boolean = false,

    val needLogin: Boolean = true
)