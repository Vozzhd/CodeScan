package com.example.codescan.history.domain.impl

import com.example.codescan.history.domain.api.HistoryRepository
import com.example.codescan.root.network.NetworkClient
import com.example.codescan.scan.domain.entity.BoxData
import com.example.codescan.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HistoryRepositoryImpl(
    private val networkClient: NetworkClient
) : HistoryRepository {
    override fun getData(): Flow<Resource<List<BoxData>>> = flow {
        val response = networkClient.doRequest(GetDataRequest())
        when (response.resultCode) {
            200 -> {
                with(response as GetDataResponse) {
                    val data = response.dataEntries.map {
                        BoxData(
                            packageCode = it.packageCode,
                            lineCode = it.lineCode
                        )
                    }
                    emit(Resource.Success(data))
                }
            }
            else -> emit(Resource.Error("Internet error"))
        }
    }
}