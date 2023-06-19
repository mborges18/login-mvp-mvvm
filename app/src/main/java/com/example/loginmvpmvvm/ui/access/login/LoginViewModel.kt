package com.example.loginmvpmvvm.ui.access.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.loginmvpmvvm.common.ResultState
import com.example.loginmvpmvvm.model.SignInRequest
import com.example.loginmvpmvvm.model.SignInResponse
import com.example.loginmvpmvvm.model.User
import com.example.loginmvpmvvm.repositories.AccessRepository
import com.example.loginmvpmvvm.repositories.AccessRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel(
    private val repository: AccessRepository
) : ViewModel() {

    val usersLiveData = MutableLiveData<List<User>>()
    val errorMsg = MutableLiveData<String>()
    val signIn = MutableLiveData<SignInResponse?>()

    fun signIn(email: String, password: String) = viewModelScope.launch {

        val signInRequest = SignInRequest(email = email, password = password)
        when (val response = repository.signIn(signInRequest)) {

            is ResultState.Success -> {
                signIn.value = response.data
            }

            is ResultState.Error -> {
                signIn.value = null
            }

            is ResultState.Failure -> {
                signIn.value = null
            }
        }
    }
}