package com.example.loginmvpmvvm.retrofit

import com.example.loginmvpmvvm.model.SignInRequest
import com.example.loginmvpmvvm.model.SignInResponse
import com.example.loginmvpmvvm.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @POST("signin/")
    suspend fun signIn(@Body signIn: SignInRequest): Response<SignInResponse>
}