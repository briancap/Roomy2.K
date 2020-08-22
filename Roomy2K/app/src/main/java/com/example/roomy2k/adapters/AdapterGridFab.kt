package com.example.roomy2k.adapters

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.roomy2k.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class AdapterGridFab(val context : Context?, private val adapterData : MutableList<MutableMap<String, String>> ) : RecyclerView.Adapter<AdapterGridFab.ViewHolder>() {

    val LOG_TAG: String = javaClass.name

    lateinit var gridLabel : String

    init{
        if( context != null ){
            val resources : Resources = context.resources

            gridLabel = resources.getString( R.string.adapter_grid_label )
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var gridItemFab: FloatingActionButton = view.findViewById(R.id.grid_item_fab)
        var gridItemFabLabel: TextView = view.findViewById(R.id.grid_item_fab_label)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_item_fab, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val itemData : MutableMap<String, String> = adapterData.get( position )

        holder.gridItemFabLabel.text = itemData[ gridLabel ]
        holder.gridItemFab.setOnClickListener {
            Log.e( LOG_TAG, "FAB clicked position = " + position )
        }
    }

    override fun getItemCount(): Int {
        return adapterData.size
    }
}
