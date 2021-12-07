package com.example.network.entity

import java.io.Serializable

/**
 * @Description:
 * @CreateDate: 2021/12/3 10:47
 */
open class ApiResponse<T>(
    open val data: T? = null,
    open val code: String? = null,
    open val msg: String? = null,
    open val error: Throwable? = null
) : Serializable {
    val isSuccess: Boolean
        get() = code == "SUCCESS"
}

data class ApiSuccessResponse<T>(val response: T) : ApiResponse<T>(data = response)

class ApiEmptyResponse<T> : ApiResponse<T>()

data class ApiFailedResponse<T>(override val code: String?, override val msg: String?) :
    ApiResponse<T>(code = code, msg = msg)

data class ApiErrorResponse<T>(val throwable: Throwable) : ApiResponse<T>(error = throwable)