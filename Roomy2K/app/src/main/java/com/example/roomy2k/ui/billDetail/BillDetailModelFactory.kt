package com.example.roomy2k.ui.billDetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber

class BillDetailModelFactory( val billName : String? ) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        Timber.e( "in create" )
        return BillDetailViewModel( billName ) as T
    }

}