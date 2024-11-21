package com.example.codescan.root.network

import com.example.codescan.root.network.retrofit.Response

interface NetworkClient {
    suspend fun postData(dto: Any): Response
}