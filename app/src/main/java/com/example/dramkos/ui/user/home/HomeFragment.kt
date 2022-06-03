package com.example.dramkos.ui.user.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dramkos.core.data.repository.AppRepository
import com.example.dramkos.databinding.FragmentHomeAdminBinding
import com.example.dramkos.databinding.FragmentHomeUserBinding
import com.example.dramkos.ui.user.home.adapter.ProductKosAdapter
import com.example.dramkos.ui.navigation.NavigationUserActivity
import com.example.dramkos.util.Constants
import com.example.dramkos.util.Prefs

import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.concurrent.schedule

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeUserBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HomeViewModel

    private val adapterProductKos = ProductKosAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeUserBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setData()
        setupAdapter()
        mainButton()
        return root
    }


    private fun setupAdapter() {
        binding.rvProductKos.adapter = adapterProductKos
    }

    private fun setData() {
        viewModel.listKos.observe(requireActivity(), {
            Log.d("TAG", "cekkk" + Constants.dataaa)
            adapterProductKos.addItems(Constants.dataaa)
        })
    }

    fun mainButton() {

    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}