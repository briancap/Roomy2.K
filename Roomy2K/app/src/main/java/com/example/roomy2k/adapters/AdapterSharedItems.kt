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


class AdapterSharedItems( val context : Context? ) : RecyclerView.Adapter<AdapterSharedItems.ViewHolder>() {

    val LOG_TAG: String = javaClass.simpleName

    lateinit var itemLabel : String
    lateinit var itemRemaining : String

    var adapterData : MutableList<MutableMap<String, Object>> = mutableListOf()

    init{
        if( context != null ){
            val resources : Resources = context.resources

            itemLabel = resources.getString( R.string.adapter_item_label )
            itemRemaining = resources.getString( R.string.adapter_item_remaining )
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var sharedItemIcon: ImageView = view.findViewById( R.id.li_shared_image )
        var sharedItemName: TextView = view.findViewById( R.id.li_shared_name )
        var sharedItemProgressBar: ProgressBar = view.findViewById( R.id.li_shared_progress_bar )
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_shared_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val itemData : MutableMap<String, Object> = adapterData.get( position )

        holder.sharedItemIcon.setImageResource( R.drawable.ic_menu_camera )
        holder.sharedItemName.text = itemData[itemLabel] as String
        holder.sharedItemProgressBar.progress = itemData[itemRemaining] as Int
    }

    override fun getItemCount(): Int {
        return adapterData.size
    }

    fun setData( data : MutableList<MutableMap<String, Object>>  ){
        Log.v( LOG_TAG, "in setData" )
        adapterData = data
        notifyDataSetChanged()
    }
}
