package me.aofz.acfb.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.aofz.acfb.model.Fish
import me.aofz.acfb.model.ResourceState
import me.aofz.acfb.repository.Repository

class GalleryViewModel @ViewModelInject constructor(private val repository: Repository) :
    ViewModel() {

    private val _uiState: MutableStateFlow<ResourceState<List<Fish>>> =
        MutableStateFlow(ResourceState.Loading)

    val uiState: StateFlow<ResourceState<List<Fish>>>
        get() = _uiState

    init {
        viewModelScope.launch {
            repository.getFishList().collect { _uiState.value = it }
        }
    }
}