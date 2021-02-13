package me.aofz.acfb.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.xwray.groupie.Group
import com.xwray.groupie.GroupieAdapter
import dagger.hilt.android.AndroidEntryPoint
import me.aofz.acfb.databinding.GalleryFragmentBinding
import me.aofz.acfb.model.Fish

@AndroidEntryPoint
class GalleryFragment : Fragment() {

    private lateinit var binding: GalleryFragmentBinding
    private val viewModel by viewModels<GalleryViewModel>()
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

        binding.galleryContainer.adapter = adapter
        gallaryObserver()
        viewModel.fetchRemote()
    }

    private fun gallaryObserver() {
        viewModel.collection.observe(viewLifecycleOwner, Observer {
            it?.let { fishList ->
                adapter.update(mutableListOf<Group>().apply {
                    fishList.forEach { fish ->
                        this.add(GalleryItem(fish))
                    }
                })
            }
        })
    }
}