package com.github.aliguvenc.coroutinesanddagger

import retrofit2.Response

interface Api {

    suspend fun <T : Any> call(call: suspend () -> Response<T>): ApiResult<T> {
        var result: ApiResult<T>? = null
        try {
            val response = call.invoke()
            if (response.isSuccessful) {
                response.body()?.let {
                    result =
                        ApiResult.Success(response.body()!!)
                } ?: run {
                    result = ApiResult.Error(
                        null,
                        null,
                        "response body is empty"
                    )
                }
            } else {
                result = ApiResult.Error(
                    null,
                    response.code(),
                    "error"
                )
            }
        } catch (e: Exception) {
            result = ApiResult.Error(e, null, "null")
        }

        return result!!
    }
}