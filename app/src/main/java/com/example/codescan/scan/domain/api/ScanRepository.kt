package com.example.codescan.scan.domain.api

import com.example.codescan.scan.domain.entity.BoxData
import com.example.codescan.util.Resource
import kotlinx.coroutines.flow.Flow

interface ScanRepository {
    fun postData(data: BoxData): Flow<Resource<String>>
}