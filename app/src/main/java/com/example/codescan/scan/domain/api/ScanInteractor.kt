package com.example.codescan.scan.domain.api

import com.example.codescan.scan.domain.entity.BoxData
import kotlinx.coroutines.flow.Flow

interface ScanInteractor {
    fun postData(data: BoxData): Flow<Pair<String?, String?>>
}