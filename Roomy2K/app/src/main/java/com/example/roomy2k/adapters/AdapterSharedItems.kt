package com.example.roomy2k.adapters

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomy2k.R


class AdapterSharedItems(val context : Context?, private val adapterData : MutableList<MutableMap<String, String>> ) : RecyclerView.Adapter<AdapterSharedItems.ViewHolder>() {

    lateinit var itemLabel : String

    init{
        if( context != null ){
            val resources : Resources = context.resources

            itemLabel = resources.getString( R.string.adapter_item_label )
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
        val itemData : MutableMap<String, String> = adapterData.get( position )

        holder.sharedItemIcon.setImageResource( R.drawable.ic_menu_camera )
        holder.sharedItemName.text = itemData[ itemLabel ]
        holder.sharedItemProgressBar.progress = 40
    }

    override fun getItemCount(): Int {
        return adapterData.size
    }
}
