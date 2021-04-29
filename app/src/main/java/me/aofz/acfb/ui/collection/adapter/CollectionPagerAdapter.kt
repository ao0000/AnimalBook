package me.aofz.acfb.ui.collection.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import me.aofz.acfb.model.ItemType
import me.aofz.acfb.ui.collection.CollectionFragment
import me.aofz.acfb.ui.collection.gallery.GalleryFragment

class CollectionPagerAdapter(parentFragment: Fragment) : FragmentStateAdapter(parentFragment) {

    override fun createFragment(position: Int): Fragment {
        val fragment: Fragment = GalleryFragment()
        val item: ItemType = ItemType.values()[position]
        fragment.arguments = Bundle().apply {
            putSerializable(CollectionFragment.ITEM_KEY, item)
        }
        return fragment
    }

    override fun getItemCount(): Int = ItemType.values().size
}