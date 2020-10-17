package com.example.roomy2k.ui.billDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomy2k.R
import com.example.roomy2k.databinding.FragmentBillDetailBinding
import timber.log.Timber


class BillDetailFragment : Fragment() {

    private lateinit var billDetailViewModel: BillDetailViewModel
    private lateinit var binding: FragmentBillDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        Timber.v("onCreate")

        val billName : String? = arguments?.getString(resources.getString(R.string.intent_activity_start_bill_name))
        Timber.e("bill name " + billName)

        //val billDetailViewModel : BillDetailViewModel by viewModels()
        //billDetailViewModel.setBillName( billName )

        val billDetailViewModel = ViewModelProvider(this, BillDetailModelFactory(billName)).get(
            BillDetailViewModel::class.java
        )

        Timber.e("initializing data binding")

        // val root = inflater.inflate(R.layout.fragment_bill_detail, container, false)
        binding = DataBindingUtil.inflate( inflater, R.layout.fragment_bill_detail, container, false )

        Timber.e("end initializing data binding")

        billDetailViewModel.amount.observe(viewLifecycleOwner, Observer<String?> { amount ->
            Timber.e("in amount observe")
            //textViewAmount.text = amount
            binding.detailBillCurrentValueAmount.text = amount
        })

        billDetailViewModel.due.observe(viewLifecycleOwner, Observer<String?> { due ->
            Timber.e("in amount observe")
            //textViewDue.text = due
            binding.detailBillCurrentValueDue.text = due
        })

        billDetailViewModel.paymentMethod.observe(
            viewLifecycleOwner,
            Observer<String?> { paymentMethod ->
                Timber.e("in amount observe")
                //textViewPaymentMethod.text = paymentMethod
                binding.detailBillCurrentValuePayment.text = paymentMethod
            })

        billDetailViewModel.paidTo.observe(viewLifecycleOwner, Observer<String?> { paidTo ->
            Timber.e("in amount observe")
            //textViewPaidTo.text = paidTo
            binding.detailBillCurrentValueTarget.text = paidTo
        })

        billDetailViewModel.paymentMode.observe(
            viewLifecycleOwner,
            Observer<String?> { paymentMode ->
                Timber.e("in amount observe")
                //textViewPaymentMode.text = paymentMode
                binding.detailBillCurrentValuePaymentMode.text = paymentMode
            })

        return binding.root
    }

}