package com.example.codescan.scan.ui

import android.content.Context
import android.content.IntentFilter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.codescan.root.BarcodeBroadcastReceiver
import com.example.codescan.util.ConstantValues.Companion.SCANNER_ACTION_BARCODE


class ScanViewModel(
//    barcodeBroadcastReceiver: BarcodeBroadcastReceiver
) : ViewModel() {

    private val boxMutableLiveData = MutableLiveData<String>()
    fun observeBoxLiveData(): LiveData<String> = boxMutableLiveData

    fun registerBroadcastReceiver(context: Context) {
        val intentFilter = IntentFilter()
        intentFilter.addAction(SCANNER_ACTION_BARCODE)
        context.applicationContext.registerReceiver(
            BarcodeBroadcastReceiver(),
            intentFilter,
            Context.RECEIVER_NOT_EXPORTED
           )

        //barcodeBroadcastReceiver.onReceive(context, Intent())
       // boxMutableLiveData.value = BarcodeBroadcastReceiver.readCode
    }
}