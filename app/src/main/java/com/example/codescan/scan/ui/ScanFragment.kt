package com.example.codescan.scan.ui

import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.registerReceiver
import androidx.fragment.app.Fragment
import com.example.codescan.databinding.FragmentScanBinding
import com.example.codescan.root.BarcodeBroadcastReceiver
import com.example.codescan.util.App.Companion.readCode
import com.example.codescan.util.ConstantValues.Companion.SCANNER_ACTION_BARCODE
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScanFragment : Fragment() {

    private val viewModel by viewModel<ScanViewModel>()
    private val barcodeBroadcastReceiver: BarcodeBroadcastReceiver = BarcodeBroadcastReceiver()
    private var _binding: FragmentScanBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScanBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

        val intentFilter = IntentFilter()
        intentFilter.addAction(SCANNER_ACTION_BARCODE)

        registerReceiver(
            requireContext(),
            barcodeBroadcastReceiver,
            intentFilter,
            ContextCompat.RECEIVER_EXPORTED
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        readCode.observe(viewLifecycleOwner) {
            viewModel.manageScanData(it)
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }

        viewModel.observeLineData().observe(viewLifecycleOwner) { writeDataToLineField(it) }
        viewModel.observeBoxData().observe(viewLifecycleOwner) { writeDataToBoxField(it) }

    }

    private fun writeDataToBoxField(scannedBoxNumber: String?) {
        binding.boxCode.text = scannedBoxNumber
    }

    private fun writeDataToLineField(scannedLineNumber: String?) {
        binding.lineCode.text = scannedLineNumber
    }

    override fun onStop() {
        super.onStop()
        requireActivity().unregisterReceiver(barcodeBroadcastReceiver)
    }

}