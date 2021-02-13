package me.aofz.acfb.ui

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import me.aofz.acfb.R
import me.aofz.acfb.databinding.GalleryItemBinding
import me.aofz.acfb.model.Fish

class GalleryItem(val fish: Fish) : BindableItem<GalleryItemBinding>() {

    override fun getLayout(): Int = R.layout.gallery_item

    override fun bind(viewBinding: GalleryItemBinding, position: Int) {
        viewBinding.nameText.text = fish.name
        viewBinding.displayPriceText.text = fish.price.toString()
    }

    override fun initializeViewBinding(view: View): GalleryItemBinding =
        GalleryItemBinding.bind(view)
}