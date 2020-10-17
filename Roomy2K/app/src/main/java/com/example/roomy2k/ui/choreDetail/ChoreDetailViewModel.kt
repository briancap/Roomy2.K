package com.example.roomy2k.ui.choreDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomy2k.TestData
import timber.log.Timber

class ChoreDetailViewModel() : ViewModel() {

    val testData : TestData = TestData()

    //Chore Detail
    val _choreDetailData = MutableLiveData<MutableList<MutableMap<String, String>>>().apply{
        Timber.e( "in _choreDetailData apply section" )
        value = testData.getChoreDetail()
    }

    fun getChoreData() : LiveData<MutableList<MutableMap<String, String>>> {
        Timber.e( "in getChoreData" )
        return _choreDetailData
    }

}