package com.example.roomy2k.ui.billDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BillDetailViewModel : ViewModel() {
    val LOG_TAG: String = javaClass.name

    private var billName : String? = ""
    fun setBillName( billNameValue : String? ){
        Log.e( LOG_TAG, "setting billName = " + billNameValue )
        billName = billNameValue
    }


    private val _amount = MutableLiveData<String>().apply {

    }
    val amount: LiveData<String> = _amount


    private val _due = MutableLiveData<String>().apply {

    }
    val due: LiveData<String> = _due


    private val _paymentMethod = MutableLiveData<String>().apply {

    }
    val paymentMethod: LiveData<String> = _paymentMethod


    private val _paidTo = MutableLiveData<String>().apply {

    }
    val paidTo: LiveData<String> = _paidTo


    private val _paymentMode = MutableLiveData<String>().apply {

    }
    val paymentMode: LiveData<String> = _paymentMode


}