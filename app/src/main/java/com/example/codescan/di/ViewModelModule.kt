package com.example.codescan.di

import com.example.codescan.history.ui.HistoryViewModel
import com.example.codescan.scan.ui.ScanViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ScanViewModel(get())
    }
    viewModel {
        HistoryViewModel(get())
    }
}