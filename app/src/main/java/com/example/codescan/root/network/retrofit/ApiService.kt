package com.example.codescan.root.network.retrofit

import com.example.codescan.scan.domain.entity.BoxData
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/posts")
    suspend fun postData(@Body data: BoxData): Response
}