package com.acsent.androidmista.topicsList

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.acsent.androidmista.databinding.FragmentTopicsListBinding

class TopicsListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTopicsListBinding.inflate(layoutInflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = ListViewAdapter()

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = false
            viewModel.update()
        }

        return binding.root
    }

}