package com.example.myapiandoridapp.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapiandoridapp.data.model.Entity

class EntityAdapter(private val onItemClick: (Entity) -> Unit) :
    ListAdapter<Entity, EntityAdapter.ViewHolder>(EntityDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemEntityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemEntityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(entity: com.example.myapiandoridapp.data.model.Entity) {
            binding.assetTypeTextView.text = entity.assetType
            binding.tickerTextView.text = entity.ticker
            binding.currentPriceTextView.text = "$${entity.currentPrice}"
            binding.dividendYieldTextView.text = "${entity.dividendYield}%"
            binding.root.setOnClickListener { onItemClick(entity) }
        }
    }

    class EntityDiffCallback : DiffUtil.ItemCallback<com.example.myapiandoridapp.data.model.Entity>() {
        override fun areItemsTheSame(oldItem: Entity, newItem: Entity): Boolean {
            return oldItem.ticker == newItem.ticker
        }

        override fun areContentsTheSame(oldItem: Entity, newItem: Entity): Boolean {
            return oldItem == newItem
        }
    }
}