package com.example.codescan.scan.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScanViewModel : ViewModel() {

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

    private fun manageLineCode(scanData: String) {
        lineData.postValue(scanData)
    }
    private fun manageBoxCode(scanData: String) {
        boxData.postValue(scanData)
    }

}