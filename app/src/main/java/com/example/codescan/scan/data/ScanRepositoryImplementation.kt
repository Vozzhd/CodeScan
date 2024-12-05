package com.example.codescan.scan.data

import com.example.codescan.root.network.NetworkClient
import com.example.codescan.scan.data.network.PostDataRequest
import com.example.codescan.scan.domain.api.ScanRepository
import com.example.codescan.scan.domain.entity.BoxData
import com.example.codescan.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ScanRepositoryImplementation(
    private val networkClient: NetworkClient
) : ScanRepository {
    override fun postData(data: BoxData): Flow<Resource<String>> = flow {
        val response = networkClient.doRequest(PostDataRequest(data))
        emit(
            when (response.resultCode) {
                -1 -> Resource.Error("Connection error")
                200 -> Resource.Success(response.toString())
                else -> Resource.Error("Unknown error")
            }
        )
    }
}
