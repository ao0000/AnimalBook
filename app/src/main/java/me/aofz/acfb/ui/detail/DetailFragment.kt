package me.aofz.acfb.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.aofz.acfb.R
import me.aofz.acfb.databinding.DetailFragmentBinding
import me.aofz.acfb.model.LoadingState

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.detail_fragment) {

    private val binding: DetailFragmentBinding by viewBinding()

    private val viewModel: DetailViewModel by viewModels()

    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
        }

        viewModel.fetchItem(args.animalType, args.id)
        lifecycleScope.launch {
            viewModel.uiState.collect { viewState ->
                when (viewState) {
                    is LoadingState.Loading -> {
                        val loadingText: String = resources.getString(R.string.loading_toast_text)
                        Toast.makeText(context, loadingText, Toast.LENGTH_SHORT).show()
                    }
                    is LoadingState.Success -> {
                        binding.animal = viewState.data
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