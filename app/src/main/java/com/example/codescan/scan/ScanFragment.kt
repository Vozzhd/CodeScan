package com.example.codescan.scan

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.registerReceiver
import androidx.fragment.app.Fragment
import com.example.codescan.R
import com.example.codescan.util.ConstantValues
import com.example.codescan.util.ConstantValues.Companion.SCANNER_ACTION_BARCODE

class ScanFragment : Fragment() {
    private val barcodeBroadcastReceiver = BarcodeBroadcastReceiver()

    companion object {
        fun newInstance() = ScanFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_scan, container, false)
    }

    class BarcodeBroadcastReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val txt = intent?.getStringExtra(ConstantValues.SCANNER_EXTRA_BARCODE_DATA)
            Toast.makeText(context, txt, Toast.LENGTH_LONG).show()
        }
    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter()
        intentFilter.addAction(SCANNER_ACTION_BARCODE)
        registerReceiver(
            requireContext(),
            barcodeBroadcastReceiver,
            intentFilter,
            ContextCompat.RECEIVER_EXPORTED
        )
    }

    override fun onStop() {
        requireActivity().unregisterReceiver(barcodeBroadcastReceiver)
        super.onStop()

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}