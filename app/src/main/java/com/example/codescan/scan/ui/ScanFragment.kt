package com.example.codescan.scan.ui

import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.codescan.R
import com.example.codescan.util.App.Companion.readCode
import com.example.codescan.util.ConstantValues.Companion.SCANNER_ACTION_BARCODE
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScanFragment : Fragment() {
    private val viewModel by viewModel<ScanViewModel>()
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

        viewModel.registerBroadcastReceiver(requireContext())


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readCode.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
        viewModel.registerBroadcastReceiver(requireContext())
        viewModel.observeBoxLiveData().observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }

}