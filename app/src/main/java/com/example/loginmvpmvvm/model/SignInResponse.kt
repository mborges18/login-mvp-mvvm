package com.example.loginmvpmvvm.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SignInResponse(
    @SerializedName("iduser") val idUser: String
): Serializable
