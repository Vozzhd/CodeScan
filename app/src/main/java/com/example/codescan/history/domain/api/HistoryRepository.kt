package com.example.codescan.history.domain.api


import com.example.codescan.scan.domain.entity.BoxData
import com.example.codescan.util.Resource
import kotlinx.coroutines.flow.Flow


interface HistoryRepository {
    fun getData() : Flow<Resource<List<BoxData>>>
}
