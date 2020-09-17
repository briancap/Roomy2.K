package com.example.roomy2k.ui.home

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomy2k.BillDetailActivity
import com.example.roomy2k.R
import com.example.roomy2k.TestData
import com.example.roomy2k.adapters.AdapterGridFab
import com.example.roomy2k.adapters.AdapterSharedItems
import com.example.roomy2k.custom.RecyclerItemClickListener


class HomeFragment : Fragment() {

    val LOG_TAG: String = javaClass.name
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
        val gridBills: RecyclerView = root.findViewById(R.id.home_grid_bills)
        gridBills.setHasFixedSize(true)
        gridBills.layoutManager = GridLayoutManager(context, 4)
        gridBills.adapter = AdapterGridFab(context, TestData(context).getBills())

        //Shared Item Section
        val listSharedItems: RecyclerView = root.findViewById(R.id.home_list_shared)
        listSharedItems.setHasFixedSize(true)
        listSharedItems.layoutManager = LinearLayoutManager(context)
        listSharedItems.adapter = AdapterSharedItems(context, TestData(context).getSharedItems())

        listSharedItems.addOnItemTouchListener(
            RecyclerItemClickListener(
                context,
                listSharedItems,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {
                        Log.e(LOG_TAG, "onItemClick")
                        val intent = Intent( context, BillDetailActivity::class.java ).apply {
                            putExtra( "test", "test value")
                        }
                        startActivity( intent )
                    }

                    override fun onLongItemClick(view: View?, position: Int) {
                        Log.e(LOG_TAG, "onLongItemClick")
                    }
                }
            )
        )
/*
        //Chores Section
        val gridChores: RecyclerView = root.findViewById( R.id.home_grid_chores )
        gridChores.setHasFixedSize( true )
        gridChores.layoutManager = GridLayoutManager( context, 4 )
        gridChores.adapter = AdapterGridItem( context, TestData( context ).getChores() )
*/

        /*
        val textView: TextView = root.findViewById(R.id.home_grid_bills)

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
         */
        return root
    }
}