package me.aofz.acfb.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import me.aofz.acfb.R
import me.aofz.acfb.databinding.GalleryFragmentBinding
import me.aofz.acfb.model.LoadingState
import me.aofz.acfb.ui.adapter.GalleryAdapter

@AndroidEntryPoint
class GalleryFragment : Fragment(R.layout.gallery_fragment) {

    private val binding: GalleryFragmentBinding by viewBinding()

    private val viewModel: GalleryViewModel by viewModels()

    private val adapter = GalleryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            galleryContainer.adapter = adapter
        }

        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { uiState ->
                when (uiState) {
                    is LoadingState.Loading -> {
                        val loadingText: String = resources.getString(R.string.loading_toast_text)
                        Toast.makeText(context, loadingText, Toast.LENGTH_SHORT).show()
                    }
                    is LoadingState.Success -> {
                        adapter.submitList(uiState.data)
                        val successText: String = resources.getString(R.string.success_toast_text)
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
}