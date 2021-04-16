package me.aofz.acfb.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.Group
import com.xwray.groupie.GroupieAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import me.aofz.acfb.databinding.GalleryFragmentBinding
import me.aofz.acfb.model.ResourceState

@AndroidEntryPoint
class GalleryFragment : Fragment() {

    private lateinit var binding: GalleryFragmentBinding
    private val viewModel: GalleryViewModel by viewModels()
    private val adapter = GroupieAdapter()

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

        binding.galleryContainer.apply {
            adapter = this@GalleryFragment.adapter
            layoutManager = GridLayoutManager(context, 4, LinearLayoutManager.VERTICAL, false)
        }

        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { uiState ->
                when (uiState) {
                    is ResourceState.Loading -> {
                        Toast.makeText(context, "Loading", Toast.LENGTH_LONG).show()
                    }
                    is ResourceState.Success -> {
                        adapter.update(
                            mutableListOf<Group>().apply {
                                uiState.data.forEach { fish ->
                                    this.add(GalleryItem(fish))
                                }
                            }
                        )
                    }
                    is ResourceState.Error -> {
                        Toast.makeText(context, "Loading", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}