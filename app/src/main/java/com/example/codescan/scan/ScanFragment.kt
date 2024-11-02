package com.example.codescan.scan

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.registerReceiver
import androidx.fragment.app.Fragment
import com.example.codescan.R
import com.example.codescan.util.BarcodeBroadcastReceiver
import com.example.codescan.util.ConstantValues


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

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.android.server.scannerservice.broadcast")
        registerReceiver(
            requireContext(),
            barcodeBroadcastReceiver,
            intentFilter,
            ContextCompat.RECEIVER_EXPORTED
        )
        barcodeBroadcastReceiver.onReceive(requireContext(), Intent())
    }

    override fun onStop() {
        super.onStop()
    }
}