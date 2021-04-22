package me.aofz.acfb.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("setImage")
fun ImageView.setImage(url: String) = this.load(url)