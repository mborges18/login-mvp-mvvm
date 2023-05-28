package com.example.loginmvpmvvm.di

import com.example.loginmvpmvvm.repositories.AccessRepository
import com.example.loginmvpmvvm.repositories.AccessRepositoryImpl
import com.example.loginmvpmvvm.retrofit.BuilderRetrofit
import com.example.loginmvpmvvm.ui.access.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module(override = true) {

    viewModel { LoginViewModel(repository = get()) }

    factory<AccessRepository> { AccessRepositoryImpl(api = get()) }

    single { BuilderRetrofit.getInstance() }
}