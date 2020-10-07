package com.example.roomy2k.ui.billDetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BillDetailModelFactory( val billName : String? ) : ViewModelProvider.Factory {
    val LOG_TAG: String = javaClass.name

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        Log.e( LOG_TAG, "in create" )
        return BillDetailViewModel( billName ) as T
    }

}