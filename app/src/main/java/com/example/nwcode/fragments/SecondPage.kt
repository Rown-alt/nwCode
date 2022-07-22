package com.example.nwcode.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.nwcode.R
import com.example.nwcode.adapters.CollectionAdapter
import com.example.nwcode.viewModels.SecondPageViewModel
import com.example.nwcode.viewModels.SecondPageViewModelFactory

class SecondPage : Fragment(R.layout.fragment_second_page) {

    private val  viewModel : SecondPageViewModel by activityViewModels{ SecondPageViewModelFactory() }
    private val arguments : SecondPageArgs by navArgs()
    private lateinit var recyclerView : RecyclerView
    private val adapter = CollectionAdapter()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.getCollection(arguments.title)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.secondPage_RV)

        viewModel.collection.observe(viewLifecycleOwner){
            adapter.setCollection(it.results)
        }
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = adapter
    }
}