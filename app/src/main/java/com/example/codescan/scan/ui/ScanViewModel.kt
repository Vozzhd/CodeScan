package com.example.codescan.scan.ui

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.codescan.root.BarcodeBroadcastReceiver
import com.example.codescan.scan.domain.api.ScanInteractor
import com.example.codescan.scan.domain.entity.BoxData
import com.example.codescan.util.ConstantValues.Companion.SCANNER_ACTION_BARCODE

class ScanViewModel(
    private val scanInteractor: ScanInteractor,
    private val barcodeBroadcastReceiver: BarcodeBroadcastReceiver
) : ViewModel() {

    private val boxMutableLiveData = MutableLiveData<BoxData>()
    fun observeBoxLiveData(): LiveData<BoxData> = boxMutableLiveData

    fun registerBroadcastReceiver(context: Context) {

        val intentFilter = IntentFilter()
        intentFilter.addAction(SCANNER_ACTION_BARCODE)
        context.applicationContext.registerReceiver(
            barcodeBroadcastReceiver,
            intentFilter,
            Context.RECEIVER_NOT_EXPORTED
        )

        barcodeBroadcastReceiver.onReceive(context, Intent())

    }
}