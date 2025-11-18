package com.example.atividadehj.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.atividadehj.storage.AppDatabase
import com.example.atividadehj.storage.Product
import com.example.atividadehj.databinding.FragmentFormProductBinding
import kotlinx.coroutines.launch

class ProductFormFragment : Fragment() {
    private var _binding: FragmentFormProductBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormProductBinding.inflate(inflater, container, false)

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val price = binding.etPrice.text.toString().toDoubleOrNull() ?: 0.0

            val db = AppDatabase.getDatabase(requireContext())
            lifecycleScope.launch {
                db.productDao().insert(Product(name = name, price = price))
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
