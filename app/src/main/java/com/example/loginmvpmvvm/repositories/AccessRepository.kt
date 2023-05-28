package com.example.loginmvpmvvm.repositories

import com.example.loginmvpmvvm.common.ResultState
import com.example.loginmvpmvvm.model.SignInRequest
import com.example.loginmvpmvvm.model.SignInResponse
import com.example.loginmvpmvvm.model.User
import com.example.loginmvpmvvm.retrofit.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class AccessRepositoryImpl(
    private val api: Api
) : AccessRepository {

    override suspend fun signIn(body: SignInRequest): ResultState<SignInResponse> {
        return try {
            val response = api.signIn(body)
            if (response.isSuccessful) {
                ResultState.Success(response.body()!!)
            } else {
                ResultState.Error("404", "Usuário ou senha inválida")
            }
        } catch (t: Throwable) {
            ResultState.Failure(t)
        }
    }

    override suspend fun register() {
        TODO("Not yet implemented")
    }
}

interface AccessRepository {
    suspend fun signIn(body: SignInRequest): ResultState<SignInResponse>
    suspend fun register()
}
