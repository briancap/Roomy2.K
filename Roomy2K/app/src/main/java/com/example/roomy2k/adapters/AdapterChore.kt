package com.example.roomy2k.adapters

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomy2k.R


class AdapterChore(val context : Context? ) : RecyclerView.Adapter<AdapterChore.ViewHolder>() {

    val LOG_TAG: String = javaClass.simpleName

    lateinit var itemLabel : String
    lateinit var itemDescription : String
    lateinit var choreFrequency : String

    var adapterData : MutableList<MutableMap<String, String>> = mutableListOf()

    init{
        Log.e( LOG_TAG, "in init" )
        if( context != null ){
            val resources : Resources = context.resources

            itemLabel = resources.getString( R.string.adapter_item_label )
            itemDescription = resources.getString( R.string.adapter_item_description )
            choreFrequency = resources.getString( R.string.adapter_item_chore_frequency )
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var choreName: TextView = view.findViewById( R.id.li_chore_name )
        var choreDescription: TextView = view.findViewById( R.id.li_chore_description )
        var choreFrequency: TextView = view.findViewById( R.id.li_chore_frequency )
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_chore, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val itemData : MutableMap<String, String> = adapterData.get( position )
        holder.choreName.text = itemData[itemLabel] as String
        holder.choreDescription.text = itemData[itemDescription] as String
        holder.choreFrequency.text = itemData[choreFrequency] as String
    }

    override fun getItemCount(): Int {
        return adapterData.size
    }

    fun setData( data : MutableList<MutableMap<String, String>>  ){
        Log.e( LOG_TAG, "in setData" )
        adapterData = data
        notifyDataSetChanged()
    }
}
