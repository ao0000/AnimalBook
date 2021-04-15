package me.aofz.acfb.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.aofz.acfb.model.Fish
import me.aofz.acfb.model.ResourceState
import me.aofz.acfb.repository.Repository

class GalleryViewModel @ViewModelInject constructor(private val repository: Repository) :
    ViewModel() {

    private val _collection = MutableLiveData<List<Fish>>()

    val collection: LiveData<List<Fish>>
        get() = _collection

    private val _errorState = MutableLiveData<Boolean>()
    val errorState: LiveData<Boolean>
        get() = _errorState

    var errorCode = "no_code"

    init {
        viewModelScope.launch {
            repository.getFishList().collect {
                when (it) {
                    is ResourceState.Loading -> {
                    }
                    is ResourceState.Success -> _collection.value = it.data!!
                    is ResourceState.Error -> {
                        errorCode = it.exception.toString()
                        _errorState.value = true
                    }
                }
            }
        }
    }
}