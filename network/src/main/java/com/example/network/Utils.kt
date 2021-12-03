package com.example.network

import com.jeremyliao.liveeventbus.LiveEventBus

/**
 * @Description:
 * @CreateDate: 2021/12/3 11:05
 */

const val SHOW_TOAST = "show_toast"
fun toast(msg: String) {
    LiveEventBus.get<String>(SHOW_TOAST).post(msg)
}