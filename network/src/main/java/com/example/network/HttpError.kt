package com.example.network

import com.google.gson.JsonParseException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.util.concurrent.CancellationException

/**
 * @Description:
 * @CreateDate: 2021/12/3 11:00
 */
enum class HttpError(var code:String,var msg:String) {
    TOKEN_EXPIRED("TOKEN_EXPIRED", "token is expired"),
    TOKEN_KICKOUT("TOKEN_KICKOUT", "token is kickout"),
    TOKEN_LACK("TOKEN_LACK","token is lack")
}

internal fun handlingApiExceptions(code: String?, errorMsg: String?) = when (code) {
    HttpError.TOKEN_EXPIRED.code -> toast(HttpError.TOKEN_EXPIRED.msg)
    HttpError.TOKEN_KICKOUT.code -> toast(HttpError.TOKEN_KICKOUT.msg)
    HttpError.TOKEN_LACK.code -> toast(HttpError.TOKEN_LACK.msg)
    else -> errorMsg?.let { toast(it) }
}

internal fun handlingExceptions(e: Throwable) = when (e) {
    is HttpException -> toast(e.message())

    is CancellationException -> {
    }
    is SocketTimeoutException -> {
    }
    is JsonParseException -> {
    }
    else -> {
    }
}
