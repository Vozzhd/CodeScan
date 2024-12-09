package com.example.codescan.history.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codescan.history.domain.api.HistoryInteractor
import kotlinx.coroutines.launch

class HistoryViewModel(private val historyInteractor: HistoryInteractor) : ViewModel() {
    fun getData() {
        viewModelScope.launch {
            historyInteractor
                .getData()
                .collect {
                    Log.d("BLYAT", it.toString())
                }
        }
    }
}