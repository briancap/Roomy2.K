package com.example.roomy2k.ui.billDetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.roomy2k.R
import com.example.roomy2k.ui.home.HomeViewModel

class BillDetailFragment : Fragment() {

    val LOG_TAG: String = javaClass.name

    private lateinit var billDetailViewModel: BillDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e( LOG_TAG, "onCreate" )
        billDetailViewModel =
            ViewModelProviders.of(this).get( BillDetailViewModel::class.java )

        val root = inflater.inflate(R.layout.fragment_bill_detail, container, false)

        return root
    }

}