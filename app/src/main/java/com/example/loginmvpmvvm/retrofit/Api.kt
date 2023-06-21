package com.example.loginmvpmvvm.retrofit

import com.example.loginmvpmvvm.model.SignInRequest
import com.example.loginmvpmvvm.model.SignInResponse
import com.example.loginmvpmvvm.model.User
import com.example.loginmvpmvvm.model.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {

    @POST("signin/")
    suspend fun signIn(@Body signIn: SignInRequest): Response<SignInResponse>

    @GET("users/{idUser}")
    suspend fun getUsersData(@Path("idUser") idUser: String): Response<UserResponse>
}