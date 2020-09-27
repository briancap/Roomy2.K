package com.example.roomy2k.ui.billDetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.roomy2k.R
import com.example.roomy2k.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.nav_header_main.*

class BillDetailFragment : Fragment() {

    val LOG_TAG: String = javaClass.name

    private lateinit var billDetailViewModel: BillDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        Log.e( LOG_TAG, "onCreate" )

        val billName : String? = arguments?.getString( resources.getString( R.string.intent_activity_start_bill_name ) )
        Log.e( LOG_TAG, "bill name " + billName )

        val billDetailViewModel : BillDetailViewModel by viewModels()
        billDetailViewModel.setBillName( billName )

        val root = inflater.inflate(R.layout.fragment_bill_detail, container, false)

        val textViewAmount : TextView = root.findViewById( R.id.detail_bill_current_value_amount )
        val textViewDue : TextView = root.findViewById( R.id.detail_bill_current_value_due )
        val textViewPaymentMethod : TextView = root.findViewById( R.id.detail_bill_current_value_payment )
        val textViewPaidTo : TextView = root.findViewById( R.id.detail_bill_current_value_target )
        val textViewPaymentMode : TextView = root.findViewById( R.id.detail_bill_current_value_payment_mode )


        billDetailViewModel.amount.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        billDetailViewModel.due.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        billDetailViewModel.paymentMethod.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        billDetailViewModel.paidTo.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        billDetailViewModel.paymentMode.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        //TODO: pass bill name into fragment, make ViewModel dynamic based on bill, set text views


        return root
    }

}