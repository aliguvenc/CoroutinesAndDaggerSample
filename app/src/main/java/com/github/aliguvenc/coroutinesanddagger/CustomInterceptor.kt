package com.github.aliguvenc.coroutinesanddagger

import com.google.gson.Gson
import okhttp3.*
import javax.inject.Inject

class CustomInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        Thread.sleep(3000)
        return Response.Builder()
            .code(200)
            .request(chain.request())
            .protocol(Protocol.HTTP_1_1)
            .message("success")
            .body(
                ResponseBody.create(
                    MediaType.get("application/json"),
                    Gson().toJson(Product(1,"a","b",2))))
            .build()
    }
}