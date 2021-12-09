package com.example.kotlincampus.utils

import android.content.Context
import android.content.Intent

/**
 * @Description:
 * @CreateDate: 2021/12/9 10:19
 */

inline fun <reified T>startActivity(context: Context,block:Intent.()->Unit){
    val intent=Intent(context,T::class.java)
    intent.block()
    context.startActivity(intent)
}