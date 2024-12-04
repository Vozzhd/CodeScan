package com.example.codescan.root

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.codescan.util.App
import com.example.codescan.util.ConstantValues

class BarcodeBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        App.readCode.postValue(
            intent?.getStringExtra(ConstantValues.SCANNER_EXTRA_BARCODE_DATA).toString()
        )
    }
}