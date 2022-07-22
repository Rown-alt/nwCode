package com.example.nwcode.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.nwcode.R
import com.example.nwcode.adapters.CategoryAdapter
import com.example.nwcode.viewModels.FirstPageViewModel
import com.example.nwcode.viewModels.FirstPageViewModelFactory
import com.example.nwcode.viewModels.ThirdPageViewModel
import com.example.nwcode.viewModels.ThirdPageViewModelFactory

class FirstPage : Fragment(R.layout.fragment_first_page) {
    private val adapter = CategoryAdapter()
    private lateinit var recyclerCategories : RecyclerView
    private val viewModel : FirstPageViewModel by activityViewModels { FirstPageViewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerCategories = view.findViewById(R.id.categories_RV)
        viewModel.collections.observe(viewLifecycleOwner){
            adapter.setCategories(it)
        }
        recyclerCategories.adapter = adapter
        recyclerCategories.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.getCollections()
        Log.e("Request", "Sending ")
    }

}