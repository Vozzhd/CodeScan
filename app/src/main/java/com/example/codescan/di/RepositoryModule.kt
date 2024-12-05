package com.example.codescan.di

import com.example.codescan.history.domain.api.HistoryRepository
import com.example.codescan.history.domain.impl.HistoryRepositoryImpl
import com.example.codescan.scan.data.ScanRepositoryImplementation
import com.example.codescan.scan.domain.api.ScanRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ScanRepository> {
        ScanRepositoryImplementation(get())
    }
    single <HistoryRepository>{HistoryRepositoryImpl(get())}
}