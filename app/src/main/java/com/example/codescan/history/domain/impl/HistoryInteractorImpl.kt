package com.example.codescan.history.domain.impl

import com.example.codescan.history.domain.api.HistoryInteractor
import com.example.codescan.history.domain.api.HistoryRepository
import com.example.codescan.scan.domain.entity.BoxData
import com.example.codescan.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HistoryInteractorImpl (private val historyRepository : HistoryRepository) : HistoryInteractor {
    override fun getData(): Flow<Pair<List<BoxData>?, String?>> {
        return historyRepository.getData().map { result->
            when (result) {
                is Resource.Error -> Pair(null,result.message)
                is Resource.Success -> Pair(result.data, null)
            }
        }
    }
}