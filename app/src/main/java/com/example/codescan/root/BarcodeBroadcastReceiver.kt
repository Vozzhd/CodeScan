package com.example.codescan.root

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.codescan.scan.data.ScanRepositoryImplementation
import com.example.codescan.util.ConstantValues

class BarcodeBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val txt = intent?.getStringExtra(ConstantValues.SCANNER_EXTRA_BARCODE_DATA)
        Toast.makeText(context, txt, Toast.LENGTH_LONG).show()
    }
}