package com.example.codescan.root

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.codescan.scan.domain.api.ScanInteractor
import com.example.codescan.scan.domain.entity.BoxData
import com.example.codescan.util.ConstantValues

class BarcodeBroadcastReceiver(
    private val scanInteractor: ScanInteractor
) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        readBox = BoxData("112233", "44556677889900")
//        val txt = intent?.getStringExtra(ConstantValues.SCANNER_EXTRA_BARCODE_DATA)
//        Toast.makeText(context, txt, Toast.LENGTH_LONG).show()
    }

    companion object {
        var readBox: BoxData = BoxData("7","7")
    }
}