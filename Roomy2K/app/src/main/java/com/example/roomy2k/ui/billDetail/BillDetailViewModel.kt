package com.example.roomy2k.ui.billDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomy2k.TestData

class BillDetailViewModel( val billName : String? ) : ViewModel() {
    val LOG_TAG: String = javaClass.simpleName

    private var billDetailData : MutableMap<String, Object> = mutableMapOf()
    private var billDataRetrieved : Boolean = false

    init {
        Log.e( LOG_TAG, "in init" )
    }


    fun getBillDetailData( attribute : String ) : String? {
        Log.e( LOG_TAG, "in getBillDetailData" )
        if( !billDataRetrieved ) {
            billDetailData = TestData().getBillData(billName)
            billDataRetrieved = true
            return billDetailData[attribute] as String?
        } else{
            return billDetailData[attribute] as String?
        }
    }


    private val _amount= MutableLiveData<String?>().apply {
        Log.e( LOG_TAG, "in _amount" )
        value = getBillDetailData( "amount" ) as String?
    }
    val amount: LiveData<String?> = _amount


    private val _due = MutableLiveData<String?>().apply {
        Log.e( LOG_TAG, "in _due" )
        value = getBillDetailData( "due" )
    }
    val due: LiveData<String?> = _due


    private val _paymentMethod = MutableLiveData<String?>().apply {
        Log.e( LOG_TAG, "in _paymentMethod" )
        value = getBillDetailData( "paymentMethod" )
    }
    val paymentMethod: LiveData<String?> = _paymentMethod


    private val _paidTo = MutableLiveData<String?>().apply {
        Log.e( LOG_TAG, "in _paidTo" )
        value = getBillDetailData( "paidTo" )
    }
    val paidTo: LiveData<String?> = _paidTo


    private val _paymentMode = MutableLiveData<String?>().apply {
        Log.e( LOG_TAG, "in _paymentMode" )
        value = getBillDetailData( "paymentMode" )
    }
    val paymentMode: LiveData<String?> = _paymentMode


}