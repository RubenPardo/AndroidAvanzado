package com.example.androidavanzado.presentation.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidavanzado.Model
import com.example.androidavanzado.R
import com.example.androidavanzado.databinding.FragmentListBinding
import org.koin.android.ext.android.inject

class ListFragment() : Fragment() {

    private lateinit var binding:FragmentListBinding
    private lateinit var adapter : ItemAdapter
    private val viewModel: ListViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater)

        initRecylerView()
        setObservers()
        getItems()


        return binding.root
    }

    private fun setObservers() {
        viewModel.loading.observe(viewLifecycleOwner,this::setLoading)
        viewModel.listItem.observe(viewLifecycleOwner,this::setItems)

    }

    private fun setItems(models: List<Model>) = adapter.setItems(models)

    private fun setLoading(isLoading: Boolean) {
        with(binding){
            rvItems.visibility = if(isLoading) View.GONE else View.VISIBLE
            pbLoading.visibility = if(isLoading) View.VISIBLE else View.GONE
        }
    }

    private fun getItems() = viewModel.getList()


    private fun initRecylerView() {
        binding.rvItems.layoutManager = LinearLayoutManager(context)
        adapter = ItemAdapter()
        binding.rvItems.adapter = adapter
    }

}