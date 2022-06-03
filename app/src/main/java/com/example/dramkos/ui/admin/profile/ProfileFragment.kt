package com.example.dramkos.ui.admin.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dramkos.MainActivity
import com.example.dramkos.databinding.FragmentProfileAdminBinding
import com.example.dramkos.ui.auth.LoginAdminActivity
import com.example.dramkos.util.Prefs
import com.inyongtisto.myhelper.extension.pushActivity

class ProfileFragment : Fragment() {

private var _binding: FragmentProfileAdminBinding? = null
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

    _binding = FragmentProfileAdminBinding.inflate(inflater, container, false)
    val root: View = binding.root

      mainButton()

    return root
  }

    override fun onResume() {
        setUser()
        super.onResume()
    }

    private fun mainButton() {
        binding.btnLogout.setOnClickListener {
            Prefs.isLogin = false
            Prefs.setAdmin(null)
            onDestroyView()
            pushActivity(LoginAdminActivity::class.java)
        }
    }

    private fun setUser() {
        val user = Prefs.getAdmin()
        if (user != null) {
            binding.apply {
                tvName.text = user.nama
                tvEmail.text = user.email
            }
        }
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}