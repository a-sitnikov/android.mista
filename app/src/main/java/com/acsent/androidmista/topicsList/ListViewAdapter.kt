package com.acsent.androidmista.topicsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.acsent.androidmista.databinding.TopicsListItemBinding
import com.acsent.androidmista.network.TopicsListItem


class ListViewAdapter: ListAdapter<TopicsListItem, ListViewAdapter.ItemViewHolder>(DiffCallback) {

    class ItemViewHolder(var binding: TopicsListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TopicsListItem) {
            binding.item = item
        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<TopicsListItem>() {
        override fun areItemsTheSame(oldItem: TopicsListItem, newItem: TopicsListItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TopicsListItem, newItem: TopicsListItem): Boolean {
            return (oldItem.author == newItem.author) &&
                   (oldItem.user == newItem.user) &&
                   (oldItem.text == newItem.text) &&
                   (oldItem.section == newItem.section) &&
                   (oldItem.count == newItem.count)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            TopicsListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}