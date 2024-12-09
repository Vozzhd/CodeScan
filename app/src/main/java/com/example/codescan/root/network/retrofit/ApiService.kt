package com.example.codescan.root.network.retrofit

import com.example.codescan.history.domain.impl.BoxDataDtoItem
import com.example.codescan.scan.domain.entity.BoxData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("LinePackageRelation")
    suspend fun postData(@Body data: BoxData): Response

    @GET("LinePackageRelation?count=10")
    suspend fun getData(): List<BoxDataDtoItem>
}