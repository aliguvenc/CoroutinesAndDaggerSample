package com.github.aliguvenc.coroutinesanddagger.extesions

import com.github.aliguvenc.coroutinesanddagger.ApiResult
import retrofit2.Response

suspend fun <T : Any> apiCall(call: suspend () -> Response<T>): ApiResult<T> {
    return try {
        val response = call.invoke()
        response.takeIf { it.isSuccessful }?.let {
            ApiResult.Success(it.body())
        } ?: ApiResult.Error(null, response.code(), response.message())
    } catch (e: Exception) {
        ApiResult.Error(e, null, e.message.toString())
    }
}