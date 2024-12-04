package com.example.codescan.di

import com.example.codescan.scan.data.ScanRepositoryImplementation
import com.example.codescan.scan.domain.api.ScanRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ScanRepository> {
        ScanRepositoryImplementation(get())
    }
}