package me.aofz.acfb.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import me.aofz.acfb.databinding.GalleryFragmentBinding
import me.aofz.acfb.model.ResourceState
import me.aofz.acfb.ui.adapter.GalleryAdapter

@AndroidEntryPoint
class GalleryFragment : Fragment() {

    private lateinit var binding: GalleryFragmentBinding

    private val viewModel: GalleryViewModel by viewModels()

    private val galleryAdapter = GalleryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GalleryFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.also {
            it.lifecycleOwner = viewLifecycleOwner
            it.adapter = galleryAdapter
        }

        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { uiState ->
                when (uiState) {
                    is ResourceState.Loading -> {
                        Toast.makeText(context, "Loading", Toast.LENGTH_LONG).show()
                    }
                    is ResourceState.Success -> {
                        galleryAdapter.submitList(uiState.data)
                    }
                    is ResourceState.Error -> {
                        Toast.makeText(context, "Loading", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}