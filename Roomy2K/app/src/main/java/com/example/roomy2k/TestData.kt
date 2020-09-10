package com.example.roomy2k

import android.content.Context
import android.content.res.Resources




class TestData( context : Context?){

    val resources: Resources? = context?.resources

    //string contants
    lateinit var gridLabel : String
    lateinit var itemLabel : String

    lateinit var itemRemaining : String

    init {
        //string constants
        if ( resources != null ){
            gridLabel = resources?.getString(R.string.adapter_item_label)
            itemLabel = resources?.getString( R.string.adapter_item_label )
            itemRemaining = resources?.getString( R.string.adapter_item_remaining )
        }
    }

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

}