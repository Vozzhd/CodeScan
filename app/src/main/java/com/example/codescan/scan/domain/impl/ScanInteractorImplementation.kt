package com.example.codescan.scan.domain.impl

import com.example.codescan.scan.domain.api.ScanInteractor
import com.example.codescan.scan.domain.api.ScanRepository
import com.example.codescan.scan.domain.entity.BoxData
import com.example.codescan.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ScanInteractorImplementation(private val repository: ScanRepository) :
    ScanInteractor {
    override fun postData(data: BoxData): Flow<Pair<String?, String?>> {
        return repository.postData(data).map { result ->
            when (result) {
                is Resource.Success -> Pair(result.data, "200")
                is Resource.Error -> Pair("bad", result.message)
            }
        }

    }
}