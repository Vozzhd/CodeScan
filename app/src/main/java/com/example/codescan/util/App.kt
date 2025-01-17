package com.example.codescan.util

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.codescan.di.dataModule
import com.example.codescan.di.interactorModule
import com.example.codescan.di.repositoryModule
import com.example.codescan.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(dataModule, interactorModule, repositoryModule, viewModelModule)
        }

    }
    companion object {
        val readCode = MutableLiveData<String>()
    }
}