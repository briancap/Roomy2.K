package com.example.roomy2k.ui.billDetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import com.example.roomy2k.R
import com.example.roomy2k.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.nav_header_main.*

class BillDetailFragment : Fragment() {

    val LOG_TAG: String = javaClass.simpleName

    private lateinit var billDetailViewModel: BillDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        Log.v( LOG_TAG, "onCreate" )

        val billName : String? = arguments?.getString( resources.getString( R.string.intent_activity_start_bill_name ) )
        Log.e( LOG_TAG, "bill name " + billName )

        //val billDetailViewModel : BillDetailViewModel by viewModels()
        //billDetailViewModel.setBillName( billName )

        val billDetailViewModel = ViewModelProvider( this, BillDetailModelFactory( billName ) ).get( BillDetailViewModel::class.java )

        val root = inflater.inflate(R.layout.fragment_bill_detail, container, false)

        Log.e( LOG_TAG, "initializing textView" )

        val textViewAmount : TextView = root.findViewById( R.id.detail_bill_current_value_amount )
        val textViewDue : TextView = root.findViewById( R.id.detail_bill_current_value_due )
        val textViewPaymentMethod : TextView = root.findViewById( R.id.detail_bill_current_value_payment )
        val textViewPaidTo : TextView = root.findViewById( R.id.detail_bill_current_value_target )
        val textViewPaymentMode : TextView = root.findViewById( R.id.detail_bill_current_value_payment_mode )

        Log.e( LOG_TAG, "end initializing textView" )

        billDetailViewModel.amount.observe( viewLifecycleOwner, Observer<String?>{ amount ->
            Log.e( LOG_TAG, "in amount observe" )
            textViewAmount.text = amount
        })

        billDetailViewModel.due.observe( viewLifecycleOwner, Observer<String?>{ due ->
            Log.e( LOG_TAG, "in amount observe" )
            textViewDue.text = due
        })

        billDetailViewModel.paymentMethod.observe( viewLifecycleOwner, Observer<String?>{ paymentMethod ->
            Log.e( LOG_TAG, "in amount observe" )
            textViewPaymentMethod.text = paymentMethod
        })

        billDetailViewModel.paidTo.observe( viewLifecycleOwner, Observer<String?>{ paidTo ->
            Log.e( LOG_TAG, "in amount observe" )
            textViewPaidTo.text = paidTo
        })

        billDetailViewModel.paymentMode.observe( viewLifecycleOwner, Observer<String?>{ paymentMode ->
            Log.e( LOG_TAG, "in amount observe" )
            textViewPaymentMode.text = paymentMode
        })

        return root
    }

}