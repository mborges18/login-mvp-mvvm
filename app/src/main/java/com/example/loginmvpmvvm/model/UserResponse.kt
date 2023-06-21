package com.example.loginmvpmvvm.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("ROWID") val rowId: String,
    @SerializedName("CREATORID") val creatorId: String,
    @SerializedName("CREATEDTIME") val createdTime: String,
    @SerializedName("MODIFIEDTIME") val modifiedTime: String,
    @SerializedName("name") val name: String,
    @SerializedName("birthdate") val birthdate: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("type") val type: String,
    @SerializedName("status") val status: String,
)
