package com.example.roomy2k.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomy2k.HomeDetailActivity
import com.example.roomy2k.R
import com.example.roomy2k.TestData
import com.example.roomy2k.adapters.AdapterGridFab
import com.example.roomy2k.adapters.AdapterSharedItems
import com.example.roomy2k.custom.RecyclerItemClickListener


class HomeFragment : Fragment() {

    val LOG_TAG: String = javaClass.name

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val homeViewModel : HomeViewModel by viewModels()

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        //Bill Section
        var billData : MutableList<MutableMap<String, String>> = mutableListOf()

        val gridBills: RecyclerView = root.findViewById(R.id.home_grid_bills)
        gridBills.setHasFixedSize(true)
        gridBills.layoutManager = GridLayoutManager(context, 4)

        val billsAdapter : AdapterGridFab = AdapterGridFab( context )
        gridBills.adapter = billsAdapter

        homeViewModel.getBills().observe( viewLifecycleOwner, Observer<MutableList<MutableMap<String, String>>>{ bills ->
            Log.v( LOG_TAG, "in get Bills observe" )
            billsAdapter.setData( bills )
            billData = bills
        })


        gridBills.addOnItemTouchListener(
            RecyclerItemClickListener(
                context,
                gridBills,
                object : RecyclerItemClickListener.OnItemClickListener{
                    override fun onItemClick(view: View?, position: Int) {
                        Log.v(LOG_TAG, "gridBills; onItemClick")
                        val intent = Intent( context, HomeDetailActivity::class.java ).apply {
                            putExtra( resources.getString( R.string.intent_activity_start_reason ), resources.getString(R.string.intent_activity_start_reason_detail_bill) )
                            putExtra( resources.getString( R.string.intent_activity_start_bill_name ), billData.get( position ).get( resources.getString( R.string.adapter_item_label ) ) )
                        }
                        startActivity( intent )
                    }

                    override fun onLongItemClick(view: View?, position: Int) {
                        Log.v(LOG_TAG, "gridBills; onLongItemClick")
                        onItemClick( view, position )
                    }
                }
            )
        )


        //Shared Item Section
        val listSharedItems: RecyclerView = root.findViewById(R.id.home_list_shared)
        listSharedItems.setHasFixedSize(true)
        listSharedItems.layoutManager = LinearLayoutManager(context)

        var sharedItemAdapter = AdapterSharedItems( context )
        listSharedItems.adapter = sharedItemAdapter

        homeViewModel.getSharedItems().observe( viewLifecycleOwner, Observer<MutableList<MutableMap<String, Object>>>{ sharedItems ->
            Log.v( LOG_TAG, "in get Bills observe" )
            sharedItemAdapter.setData( sharedItems )
        })

        listSharedItems.addOnItemTouchListener(
            RecyclerItemClickListener(
                context,
                listSharedItems,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {
                        Log.v(LOG_TAG, "listSharedItems; onItemClick")
                        val intent = Intent( context, HomeDetailActivity::class.java ).apply {
                            putExtra( resources.getString( R.string.intent_activity_start_reason ), resources.getString(R.string.intent_activity_start_reason_detail_shared) )
                        }
                        startActivity( intent )
                    }

                    override fun onLongItemClick(view: View?, position: Int) {
                        Log.v(LOG_TAG, "listSharedItems; onLongItemClick")
                        onItemClick( view, position )
                    }
                }
            )
        )

        return root
    }
}