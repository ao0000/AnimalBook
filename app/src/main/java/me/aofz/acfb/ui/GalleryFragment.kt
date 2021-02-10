package me.aofz.acfb.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import me.aofz.acfb.databinding.GalleryFragmentBinding
import me.aofz.acfb.ext.ViewModelFactory
import me.aofz.acfb.repository.Repository

class GalleryFragment : Fragment() {

    private lateinit var binding: GalleryFragmentBinding
    private val viewModel by viewModels<GalleryViewModel> { ViewModelFactory(Repository()) }

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
        viewModel.fetchRemote()
        viewModel.collection.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.sampleText.text = it.get(0).iconUri
            }
        })
    }
}