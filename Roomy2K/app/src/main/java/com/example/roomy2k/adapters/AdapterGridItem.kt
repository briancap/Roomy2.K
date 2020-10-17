package com.example.roomy2k.adapters

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomy2k.R


class AdapterGridItem(val context : Context?, private val adapterData : MutableList<MutableMap<String, String>> ) : RecyclerView.Adapter<AdapterGridItem.ViewHolder>() {

    lateinit var gridLabel : String

    init{
        if( context != null ){
            val resources : Resources = context.resources

            gridLabel = resources.getString( R.string.adapter_item_label )
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var gridItemImage: ImageView = view.findViewById(R.id.grid_item_image)
        var gridItemName: TextView = view.findViewById(R.id.grid_item_label)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_item_bills, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val itemData : MutableMap<String, String> = adapterData.get( position )

        holder.gridItemName.text = itemData[ gridLabel ]
        holder.gridItemImage.setImageResource( R.drawable.ic_launcher_background )
    }

    override fun getItemCount(): Int {
        return adapterData.size
    }
}
