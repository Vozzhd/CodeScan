package com.example.codescan.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BarcodeBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,ConstantValues.SCANNER_EXTRA_BARCODE_DATA,Toast.LENGTH_LONG).show()
    }
}