package me.aofz.acfb.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import me.aofz.acfb.ui.adapter.GalleryAdapter

@BindingAdapter("setImage")
fun ImageView.setImage(url: String) = this.load(url)

@BindingAdapter("setAdapter")
fun RecyclerView.setAdapter(adapter: GalleryAdapter) {
    this.adapter = adapter
}