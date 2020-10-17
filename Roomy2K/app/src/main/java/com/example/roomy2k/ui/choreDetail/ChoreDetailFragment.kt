package com.example.roomy2k.ui.choreDetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomy2k.R
import com.example.roomy2k.adapters.AdapterChore
import timber.log.Timber


class ChoreDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val choreDetailViewModel : ChoreDetailViewModel by viewModels()
        val root = inflater.inflate( R.layout.fragment_chore_detail, container, false )


        //Chore
        var choreData : MutableList<MutableMap<String, String>> = mutableListOf()

        val listChoreDetail: RecyclerView = root.findViewById(R.id.detail_chore_list_chores)
        listChoreDetail.setHasFixedSize(true)
        listChoreDetail.layoutManager = LinearLayoutManager(context)

        var choreDetailAdapter = AdapterChore( context )
        listChoreDetail.adapter = choreDetailAdapter

        choreDetailViewModel.getChoreData().observe( viewLifecycleOwner, Observer<MutableList<MutableMap<String, String>>>{ chores ->
            Timber.e( "in get Chore observe" )
            choreDetailAdapter.setData( chores )
            choreData = chores
        })


        return root
    }
}