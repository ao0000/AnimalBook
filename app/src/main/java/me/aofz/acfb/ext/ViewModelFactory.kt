package me.aofz.acfb.ext

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.aofz.acfb.repository.Repository
import me.aofz.acfb.ui.GalleryViewModel

class ViewModelFactory(private val repository: Repository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(
        modelClass: Class<T>
    ) = GalleryViewModel(repository) as T
}