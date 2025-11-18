package com.example.atividadehj.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.atividadehj.databinding.ItemSimpleBinding

class SimpleAdapter(private val items: List<String>) : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemSimpleBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSimpleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvText.text = items[position]
    }

    override fun getItemCount() = items.size
}
