package com.example.loginmvpmvvm.model

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("idUser") val idUser: String
)
