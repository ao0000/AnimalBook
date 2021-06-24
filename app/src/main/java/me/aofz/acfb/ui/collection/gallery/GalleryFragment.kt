package me.aofz.acfb.ui.collection.gallery

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.aofz.acfb.R
import me.aofz.acfb.databinding.GalleryFragmentBinding
import me.aofz.acfb.model.AnimalType
import me.aofz.acfb.model.LoadingState
import me.aofz.acfb.ui.collection.CollectionFragment.Companion.ITEM_KEY
import me.aofz.acfb.ui.collection.gallery.adapter.GalleryAdapter

@AndroidEntryPoint
class GalleryFragment(onClickItem: (animalType: AnimalType, id: Int) -> Unit) :
    Fragment(R.layout.gallery_fragment) {

    private val binding: GalleryFragmentBinding by viewBinding()

    private val viewModel: GalleryViewModel by viewModels()

    private val adapter = GalleryAdapter(onClickItem)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            galleryContainer.adapter = adapter
        }
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    when (uiState) {
                        is LoadingState.Loading -> {
                            val loadingText: String =
                                resources.getString(R.string.loading_toast_text)
                            Toast.makeText(context, loadingText, Toast.LENGTH_SHORT).show()
                        }
                        is LoadingState.Success -> {
                            adapter.submitList(uiState.data)
                            val successText: String =
                                resources.getString(R.string.success_toast_text)
                            Toast.makeText(context, successText, Toast.LENGTH_SHORT).show()
                        }
                        is LoadingState.Error -> {
                            val errorText: String = resources.getString(R.string.error_toast_text)
                            Toast.makeText(context, errorText, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
        fetchItem()
    }

    private fun fetchItem() {
        arguments?.let {
            val animal: AnimalType = it.getSerializable(ITEM_KEY) as AnimalType
            viewModel.fetchItem(animal)
        }
    }
}