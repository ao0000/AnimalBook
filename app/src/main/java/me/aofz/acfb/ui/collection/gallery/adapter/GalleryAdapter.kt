package me.aofz.acfb.ui.collection.gallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.aofz.acfb.databinding.GalleryItemBinding
import me.aofz.acfb.model.Item

class GalleryAdapter : ListAdapter<Item, GalleryViewHolder>(
    DiffCallBack()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder =
        GalleryViewHolder.create(parent)

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) =
        holder.bind(getItem(position))
}

class GalleryViewHolder(private val binding: GalleryItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item) {
        binding.item = item
    }

    companion object {
        fun create(parent: ViewGroup): GalleryViewHolder {
            val binding: GalleryItemBinding = GalleryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return GalleryViewHolder(binding)
        }
    }
}

class DiffCallBack : DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem.equals(newItem)
}