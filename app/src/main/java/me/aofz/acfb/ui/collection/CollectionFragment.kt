package me.aofz.acfb.ui.collection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import me.aofz.acfb.R
import me.aofz.acfb.databinding.CollectionFragmentBinding
import me.aofz.acfb.model.Item
import me.aofz.acfb.ui.collection.adapter.CollectionPagerAdapter

class CollectionFragment : Fragment(R.layout.collection_fragment) {

    private val binding: CollectionFragmentBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setPagerAdapter()
        attachTabLayout()
    }

    private fun setPagerAdapter() {
        binding.pager.adapter =
            CollectionPagerAdapter(this)
    }

    private fun attachTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = Item.values()[position].name
        }.attach()
    }

    companion object {
        const val ITEM_KEY: String = "ItemKind"
    }
}