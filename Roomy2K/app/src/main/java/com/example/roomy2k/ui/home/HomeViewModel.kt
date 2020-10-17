package com.example.roomy2k.ui.home

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomy2k.TestData
import timber.log.Timber

class HomeViewModel: ViewModel() {

    val testData : TestData = TestData()

    //Bills
    private val _billData = MutableLiveData<MutableList<MutableMap<String, String>>>().apply{
        Timber.v( "in billData apply section" )
        value = testData.getBills()
    }

    fun getBills() : LiveData<MutableList<MutableMap<String, String>>> {
        Timber.v( "in getBills" )
        return _billData
    }

    //Shared Items
    private val _sharedItems = MutableLiveData<MutableList<MutableMap<String, Object>>>().apply{
        Timber.v( "in sharedItems apply section" )
        value = testData.getSharedItems()
    }

    fun getSharedItems() : LiveData<MutableList<MutableMap<String, Object>>> {
        Timber.v( "in getSharedItems" )
        return _sharedItems
    }


}