package com.example.dramkos.ui.user.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.example.dramkos.databinding.FragmentProfileUserBinding
import com.example.dramkos.ui.admin.profile.ProfileViewModel

class ProfileFragment : Fragment() {

private var _binding: FragmentProfileUserBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

    _binding = FragmentProfileUserBinding.inflate(inflater, container, false)
    val root: View = binding.root


    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}