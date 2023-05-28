package com.example.loginmvpmvvm.model

data class User(
    val id: Int,
    var name: String,
    var mail: String,
    var password: String,
    var telefone: String,
    val sexo: String
)
