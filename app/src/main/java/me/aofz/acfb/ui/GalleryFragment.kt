package me.aofz.acfb.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import me.aofz.acfb.databinding.GalleryFragmentBinding

class GalleryFragment : Fragment() {

    private lateinit var galleryFragmentBinding: GalleryFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryFragmentBinding = GalleryFragmentBinding.inflate(inflater, container, false)
        return galleryFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        galleryFragmentBinding.sampleText.text = "sample text"
    }
}