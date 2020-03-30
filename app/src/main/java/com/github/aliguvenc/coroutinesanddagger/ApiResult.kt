package com.github.aliguvenc.coroutinesanddagger

sealed class ApiResult<out T: Any> {
    data class Success<out T : Any>(val data: T?) : ApiResult<T>()
    data class Error(val exception: Exception?,val httpCode:Int?,val message:String) : ApiResult<Nothing>()
}