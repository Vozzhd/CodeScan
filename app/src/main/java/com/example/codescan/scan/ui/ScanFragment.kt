package com.example.codescan.scan.ui

import android.content.Context
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.codescan.R
import com.example.codescan.root.BarcodeBroadcastReceiver
import com.example.codescan.util.ConstantValues.Companion.SCANNER_ACTION_BARCODE

class ScanFragment() : Fragment() {


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
        intentFilter.addAction(SCANNER_ACTION_BARCODE)


//        requireActivity().registerReceiver(
//            barcodeBroadcastReceiver,
//            intentFilter,
//            Context.RECEIVER_NOT_EXPORTED
//        )

//        registerReceiver(
//            requireContext(),
//            barcodeBroadcastReceiver,
//            intentFilter,
//            ContextCompat.RECEIVER_EXPORTED
//        )
    }

    override fun onStop() {
        //       requireActivity().unregisterReceiver(barcodeBroadcastReceiver)
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}