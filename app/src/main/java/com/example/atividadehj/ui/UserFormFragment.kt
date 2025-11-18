package com.example.atividadehj.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.atividadehj.storage.AppDatabase
import com.example.atividadehj.storage.User
import com.example.atividadehj.databinding.FragmentFormUserBinding
import kotlinx.coroutines.launch

class UserFormFragment : Fragment() {
    private var _binding: FragmentFormUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormUserBinding.inflate(inflater, container, false)

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()

            val db = AppDatabase.getDatabase(requireContext())
            lifecycleScope.launch {
                db.userDao().insert(User(name = name, email = email))
                parentFragmentManager.popBackStack()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
