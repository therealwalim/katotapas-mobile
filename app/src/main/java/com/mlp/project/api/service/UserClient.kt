package com.mlp.project.api.service
import com.mlp.project.api.Constants
import com.mlp.project.api.model.LoginRequest
import com.mlp.project.api.model.LoginResponse
import com.mlp.project.api.model.ProductResponse

import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST(Constants.LOGIN_URL)
    fun login(
        @Body login: LoginRequest
    ): Call<LoginResponse>

    @GET(Constants.PRODUCTS_URL)
    fun fetchPosts(@Header("auth-token") token: String): Call<ProductResponse>

}