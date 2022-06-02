package com.example.dramkos.ui.tambahkos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dramkos.databinding.FragmentTambahkosBinding
import com.example.dramkos.ui.rating.RatingViewModel

class TambahKosFragment : Fragment() {
    private var _binding: FragmentTambahkosBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val tambahKosViewModel =
            ViewModelProvider(this).get(RatingViewModel::class.java)

        _binding = FragmentTambahkosBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}