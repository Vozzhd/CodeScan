package com.example.codescan.history.domain.api

import com.example.codescan.scan.domain.entity.BoxData
import kotlinx.coroutines.flow.Flow

interface HistoryInteractor {
    fun getData(): Flow<Pair<List<BoxData>?, String?>>
}