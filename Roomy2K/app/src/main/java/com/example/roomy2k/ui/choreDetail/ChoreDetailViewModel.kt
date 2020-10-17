package com.example.roomy2k.ui.choreDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomy2k.TestData

class ChoreDetailViewModel() : ViewModel() {
    val LOG_TAG: String = javaClass.simpleName

    val testData : TestData = TestData()

    //Chore Detail
    val _choreDetailData = MutableLiveData<MutableList<MutableMap<String, String>>>().apply{
        Log.e( LOG_TAG, "in _choreDetailData apply section" )
        value = testData.getChoreDetail()
    }

    fun getChoreData() : LiveData<MutableList<MutableMap<String, String>>> {
        Log.e( LOG_TAG, "in getChoreData" )
        return _choreDetailData
    }

}