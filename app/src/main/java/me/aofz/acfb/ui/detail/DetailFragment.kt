package me.aofz.acfb.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import me.aofz.acfb.R
import me.aofz.acfb.databinding.DetailFragmentBinding

class DetailFragment : Fragment(R.layout.detail_fragment) {

    private val binding: DetailFragmentBinding by viewBinding()

    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
        }
    }
}