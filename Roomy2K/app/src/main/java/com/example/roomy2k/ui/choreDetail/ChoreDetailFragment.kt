package com.example.roomy2k.ui.choreDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.roomy2k.R


class ChoreDetailFragment : Fragment() {
val LOG_TAG: String = javaClass.name

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val root = inflater.inflate( R.layout.fragment_chore_detail, container, false )

        return root
    }
}