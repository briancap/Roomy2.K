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
import androidx.recyclerview.widget.RecyclerView
import com.example.roomy.adapters.AdapterGridItem
import com.example.roomy2k.R

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

        val _gridBills: RecyclerView = root.findViewById( R.id.home_grid_bills )
        _gridBills.setHasFixedSize( true )
        _gridBills.setLayoutManager( GridLayoutManager( context, 4))
        _gridBills.setAdapter( AdapterGridItem() )
        /*
        val textView: TextView = root.findViewById(R.id.home_grid_bills)

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

         */
        return root
    }
}