package com.example.roomy2k.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomy2k.R
import com.example.roomy2k.TestData
import com.example.roomy2k.adapters.AdapterGridFab
import com.example.roomy2k.adapters.AdapterGridItem
import com.example.roomy2k.adapters.AdapterSharedItems

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        //Bill Section
        val gridBills: RecyclerView = root.findViewById( R.id.home_grid_bills )
        gridBills.setHasFixedSize( true )
        gridBills.layoutManager = GridLayoutManager( context, 4 )
        gridBills.adapter = AdapterGridFab(context, TestData(context).getBills())

        //Shared Item Section
        val listSharedItems: RecyclerView = root.findViewById( R.id.home_list_shared )
        listSharedItems.setHasFixedSize( true )
        listSharedItems.layoutManager = LinearLayoutManager( context )
        listSharedItems.adapter = AdapterSharedItems( context, TestData( context ).getSharedItems() )


        //Chores Section
        val gridChores: RecyclerView = root.findViewById( R.id.home_grid_chores )
        gridChores.setHasFixedSize( true )
        gridChores.layoutManager = GridLayoutManager( context, 4 )
        gridChores.adapter = AdapterGridItem( context, TestData( context ).getChores() )


        /*
        val textView: TextView = root.findViewById(R.id.home_grid_bills)

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
         */
        return root
    }
}