package me.aofz.acfb.ui.collection.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import me.aofz.acfb.model.AnimalType
import me.aofz.acfb.ui.collection.CollectionFragment
import me.aofz.acfb.ui.collection.gallery.GalleryFragment

class CollectionPagerAdapter(
    parentFragment: Fragment,
    private val onClickItem: (animalType: AnimalType, id: Int) -> Unit
) : FragmentStateAdapter(parentFragment) {

    override fun createFragment(position: Int): Fragment {
        val fragment: Fragment = GalleryFragment(onClickItem)
        val animal: AnimalType = AnimalType.values()[position]
        fragment.arguments = Bundle().apply {
            putSerializable(CollectionFragment.ITEM_KEY, animal)
        }
        return fragment
    }

    override fun getItemCount(): Int = AnimalType.values().size
}