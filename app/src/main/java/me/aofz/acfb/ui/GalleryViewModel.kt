package me.aofz.acfb.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.aofz.acfb.repository.Repository
import me.aofz.acfb.repository.source.remote.FishEntity

class GalleryViewModel(private val repository: Repository) : ViewModel() {

    private val _collection = MutableLiveData<List<FishEntity>>()

    val collection: LiveData<List<FishEntity>>
        get() = _collection

    fun fetchRemote() {
        viewModelScope.launch {
            _collection.value = repository.getFishList()
        }
    }
}