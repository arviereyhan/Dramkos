package com.example.dramkos.ui.admin.editkos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dramkos.databinding.FragmentTambahkosBinding
import com.example.dramkos.ui.user.home.HomeFragment
import com.example.dramkos.ui.user.rating.RatingViewModel
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.pushActivity

class EditKosFragment : Fragment() {
    private var _binding: FragmentTambahkosBinding ? = null
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

    private fun mainButton() {
        binding.back.setOnClickListener {
            context?.intentActivity(HomeFragment::class.java)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
