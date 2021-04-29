package me.aofz.acfb.ui.collection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import me.aofz.acfb.R
import me.aofz.acfb.databinding.CollectionFragmentBinding
import me.aofz.acfb.model.Item
import me.aofz.acfb.ui.fish.FishFragment

class CollectionFragment : Fragment(R.layout.collection_fragment) {

    private val binding: CollectionFragmentBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pager.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return when (Item.values()[position]) {
                    Item.FISH -> FishFragment()
                    // TODO replace BugFragment from FishFragment
                    Item.BUG -> FishFragment()
                }
            }

            override fun getItemCount(): Int = Item.values().size
        }

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = Item.values()[position].name
        }.attach()
    }
}