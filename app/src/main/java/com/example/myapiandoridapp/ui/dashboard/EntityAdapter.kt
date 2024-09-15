package com.example.myapiandoridapp.ui.dashboard

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapiandoridapp.data.model.Entity
import com.example.myapiandoridapp.databinding.ItemEntityBinding

class EntityAdapter(private val onItemClick: (Entity) -> Unit) :
    ListAdapter<Entity, EntityAdapter.ViewHolder>(EntityDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate using ViewBinding
        val binding = ItemEntityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemEntityBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(entity: Entity) {
            // Set the views with data from the entity
            binding.assetType.text = entity.assetType
            binding.ticker.text = entity.ticker
            binding.currentPrice.text = "$${entity.currentPrice}"
            binding.dividendYield.text = "${entity.dividendYield}%"

            // Handle item click
            binding.root.setOnClickListener { onItemClick(entity) }
        }
    }

    class EntityDiffCallback : DiffUtil.ItemCallback<Entity>() {
        override fun areItemsTheSame(oldItem: Entity, newItem: Entity): Boolean {
            return oldItem.ticker == newItem.ticker
        }

        override fun areContentsTheSame(oldItem: Entity, newItem: Entity): Boolean {
            return oldItem == newItem
        }
    }
}
