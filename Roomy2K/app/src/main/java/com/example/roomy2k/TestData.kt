package com.example.roomy2k

import android.content.Context
import android.content.res.Resources
import android.util.Log


class TestData(){

    val LOG_TAG: String = javaClass.name

    constructor( appContext : Context? ) : this(){
        context = appContext
    }

    //string contants
    var context : Context? = null
    lateinit var gridLabel : String
    lateinit var itemLabel : String

    lateinit var itemRemaining : String

    init {
        //string constants

        if( context != null) {
            val resources: Resources? = context?.resources
            if (resources != null) {
                gridLabel = resources?.getString(R.string.adapter_item_label)
                itemLabel = resources?.getString(R.string.adapter_item_label)
                itemRemaining = resources?.getString(R.string.adapter_item_remaining)
            }
        } else {
            gridLabel = "adapter_item_label"
            itemLabel = "adapter_item_label"
            itemRemaining = "adapter_item_remaining"
        }
    }


    /**
     * Home Frag data
     */
    fun getBills() : MutableList<MutableMap<String, String>>{
        var data : MutableList<MutableMap<String, String>> = mutableListOf()

        val map1: MutableMap<String, String> = mutableMapOf()
        map1.put( gridLabel, "Rent" )

        val map2: MutableMap<String, String> = mutableMapOf()
        map2.put( gridLabel, "Internet" )

        val map3: MutableMap<String, String> = mutableMapOf()
        map3.put( gridLabel, "Electric" )

        val map4: MutableMap<String, String> = mutableMapOf()
        map4.put( gridLabel, "Gas" )

        data.add( map1 )
        data.add( map2 )
        data.add( map3 )
        data.add( map4 )

        return data
    }

    fun getSharedItems() : MutableList<MutableMap<String, Object>>{
        var data : MutableList<MutableMap<String, Object>> = mutableListOf()

        val map1: MutableMap<String, Object> = mutableMapOf()
        map1.put( itemLabel, "Olive Oil" as Object )
        map1.put( itemRemaining, 60 as Object )

        val map2: MutableMap<String, Object> = mutableMapOf()
        map2.put( itemLabel, "Toilet Paper" as Object )
        map2.put( itemRemaining, 40 as Object )

        val map3: MutableMap<String, Object> = mutableMapOf()
        map3.put( itemLabel, "Bathroom Cleaner" as Object  )
        map3.put( itemRemaining, 90 as Object )

        val map4: MutableMap<String, Object> = mutableMapOf()
        map4.put( itemLabel, "Sponges" as Object  )
        map4.put( itemRemaining, 10 as Object )

        val map5: MutableMap<String, Object> = mutableMapOf()
        map5.put( itemLabel, "Dish Detergent" as Object  )
        map5.put( itemRemaining, 50 as Object )


        data.add( map1 )
        data.add( map2 )
        data.add( map3 )
        data.add( map4 )
        data.add( map5 )

        return data
    }

    fun getChores() : MutableList<MutableMap<String, String>>{
        var data : MutableList<MutableMap<String, String>> = mutableListOf()

        val map1: MutableMap<String, String> = mutableMapOf()
        map1.put( gridLabel, "Clean Kitchen" )

        val map2: MutableMap<String, String> = mutableMapOf()
        map2.put( gridLabel, "Clean Shower" )

        val map3: MutableMap<String, String> = mutableMapOf()
        map3.put( gridLabel, "Clean Toilet" )

        val map4: MutableMap<String, String> = mutableMapOf()
        map4.put( gridLabel, "Sweep Floor" )

        data.add( map1 )
        data.add( map2 )
        data.add( map3 )
        data.add( map4 )

        return data
    }



    /**
     * BillDetail data
     */
    fun getBillData( billName : String? ) : MutableMap<String, Object>{
        Log.e( LOG_TAG, "starting getBillData" )
        var data : MutableMap<String, Object> = when( billName ) {
            "Rent" -> getRentDetails()
            "Internet" -> getInternetDtails()
            "Electric" -> getElectricDetails()
            "Gas" -> getGasDetails()
            else -> mutableMapOf()
        }

        Log.e( LOG_TAG, "data = " + data.get( "amount") )

        Log.e( LOG_TAG, "ending getBillData" )
        return data
    }

    private fun getRentDetails() : MutableMap<String, Object>{
        Log.e( LOG_TAG, "in getRentDetails" )
        val map1: MutableMap<String, Object> = mutableMapOf()

        map1.put( "amount", "1048.00" as Object )
        map1.put( "due", "May 9th" as Object )
        map1.put( "paymentMethod", "Venmo" as Object )
        map1.put( "paidTo", "Brian" as Object )
        map1.put( "paymentMode", "Auto" as Object )

        return map1
    }

    private fun getInternetDtails() : MutableMap<String, Object>{
        Log.e( LOG_TAG, "in getInternetDtails" )
        val map1: MutableMap<String, Object> = mutableMapOf()

        map1.put( "amount", "48.12" as Object )
        map1.put( "due", "May 12th" as Object )
        map1.put( "paymentMethod", "Venmo" as Object )
        map1.put( "paidTo", "Stacey" as Object )
        map1.put( "paymentMode", "Manual" as Object )

        return map1
    }

    private fun getElectricDetails() : MutableMap<String, Object>{
        Log.e( LOG_TAG, "in getElectricityDetails" )
        val map1: MutableMap<String, Object> = mutableMapOf()

        map1.put( "amount", "30.82" as Object )
        map1.put( "due", "May 18th" as Object )
        map1.put( "paymentMethod", "Venmo" as Object )
        map1.put( "paidTo", "Stacey" as Object )
        map1.put( "paymentMode", "Auto" as Object )

        return map1
    }

    private fun getGasDetails() : MutableMap<String, Object>{
        Log.e( LOG_TAG, "in getGasDetails" )
        val map1: MutableMap<String, Object> = mutableMapOf()

        map1.put( "amount", "12.32" as Object )
        map1.put( "due", "May 3th" as Object )
        map1.put( "paymentMethod", "Checking" as Object )
        map1.put( "paidTo", "Stacey" as Object )
        map1.put( "paymentMode", "Auto" as Object )

        return map1
    }

}