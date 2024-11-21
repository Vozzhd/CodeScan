package com.example.codescan.di

import com.example.codescan.root.network.NetworkClient
import com.example.codescan.root.network.retrofit.ApiService
import com.example.codescan.root.network.retrofit.RetrofitNetworkClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single<ApiService> {
        Retrofit.Builder()
            .baseUrl("http://10.170.190.230/package-traceability-api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    single<NetworkClient> { RetrofitNetworkClient(androidContext(), get()) }

}