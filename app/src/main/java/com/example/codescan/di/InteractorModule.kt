package com.example.codescan.di

import com.example.codescan.scan.domain.api.ScanInteractor
import com.example.codescan.scan.domain.impl.ScanInteractorImplementation
import org.koin.dsl.module

val interactorModule = module {
    single<ScanInteractor> { ScanInteractorImplementation(get()) }
}