package com.example.codescan.scan.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codescan.scan.domain.api.ScanInteractor
import com.example.codescan.scan.domain.entity.BoxData
import kotlinx.coroutines.launch

class ScanViewModel(
    private val scanInteractor: ScanInteractor
) : ViewModel() {

    private val lineData = MutableLiveData<String>()
    fun observeLineData(): LiveData<String> = lineData

    private val boxData = MutableLiveData<String>()
    fun observeBoxData(): LiveData<String> = boxData

    fun manageScanData(scanData: String) {
        when (scanData) {
            "1", "2" -> manageLineCode(scanData)
            else -> manageBoxCode(scanData)
        }
    }

    fun postData() {
        viewModelScope.launch {
            scanInteractor.postData(BoxData("22", "44"))
        }
    }

    private fun manageLineCode(scanData: String) {
        lineData.postValue(scanData)
    }

    private fun manageBoxCode(scanData: String) {
        boxData.postValue(scanData)
    }

}