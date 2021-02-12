package me.aofz.acfb.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.aofz.acfb.model.Fish
import me.aofz.acfb.repository.Repository

class GalleryViewModel @ViewModelInject constructor(private val repository: Repository) :
    ViewModel() {

    private val _collection = MutableLiveData<List<Fish>>()

    val collection: LiveData<List<Fish>>
        get() = _collection

    fun fetchRemote() {
        viewModelScope.launch {
            _collection.value = repository.getFishList()
        }
    }
}