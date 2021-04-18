package com.beebee.glide_dagger.ui.list_image

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.beebee.glide_dagger.R
import com.beebee.glide_dagger.databinding.ListImageItemBinding
import com.beebee.glide_dagger.domain.Image
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders

class ListImageAdapter(val clickListener: ImageClickListener) : ListAdapter<Image, ListImageAdapter.ViewHolder>(
    DiffCallback
) {
    object DiffCallback : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(private val binding: ListImageItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(image: Image, clickListener: ImageClickListener) {
            Glide.with(binding.root)
                .load(image.url)
                .into(binding.imageSource)

            binding.clickListener = clickListener
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: ListImageItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_image_item,
            parent,
            false
        )

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = getItem(position)
        holder.bind(image, clickListener)
    }
}

class ImageClickListener(val clickListener: () -> Unit) {
    fun onClick() = clickListener()
}