package com.example.codescan.root

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.codescan.scan.domain.api.ScanInteractor
import com.example.codescan.scan.domain.entity.BoxData
import com.example.codescan.util.ConstantValues

class BarcodeBroadcastReceiver(
//    private val scanInteractor: ScanInteractor
) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        readCode = intent?.getStringExtra(ConstantValues.SCANNER_EXTRA_BARCODE_DATA).toString()
        Toast.makeText(context, readCode, Toast.LENGTH_LONG).show()
    }

    companion object {
        var readCode : String = ""
    }
}