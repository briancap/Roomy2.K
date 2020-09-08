package com.example.roomy2k

import android.content.Context
import android.content.res.Resources




class TestData( context : Context?){

    val resources: Resources? = context?.resources

    //string contants
    lateinit var gridLabel : String

    init {
        //string constants
        if ( resources != null ){
            gridLabel = resources?.getString(R.string.adapter_item_label)
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

    fun getSharedItems() : MutableList<MutableMap<String, String>>{
        var data : MutableList<MutableMap<String, String>> = mutableListOf()

        val map1: MutableMap<String, String> = mutableMapOf()
        map1.put( gridLabel, "Olive Oil" )

        val map2: MutableMap<String, String> = mutableMapOf()
        map2.put( gridLabel, "Toilet Paper" )

        val map3: MutableMap<String, String> = mutableMapOf()
        map3.put( gridLabel, "Bathroom Cleaner" )

        val map4: MutableMap<String, String> = mutableMapOf()
        map4.put( gridLabel, "Sponges" )

        val map5: MutableMap<String, String> = mutableMapOf()
        map5.put( gridLabel, "Dish Detergent" )

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