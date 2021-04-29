package me.aofz.acfb.ui.collection.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.aofz.acfb.model.Item
import me.aofz.acfb.model.ItemType
import me.aofz.acfb.model.LoadingState
import me.aofz.acfb.repository.Repository
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(private val repository: Repository) :
    ViewModel() {

    private val _uiState: MutableStateFlow<LoadingState<List<Item>>> =
        MutableStateFlow(LoadingState.Loading)

    val uiState: StateFlow<LoadingState<List<Item>>>
        get() = _uiState

    fun fetchItem(itemType: ItemType) {
        viewModelScope.launch {
            when (itemType) {
                ItemType.FISH -> {
                    repository.getFishList().collect { viewState ->
                        _uiState.value = viewState
                    }
                }
                ItemType.BUG -> {
                    repository.getBugList().collect { viewState ->
                        _uiState.value = viewState
                    }
                }
            }
        }
    }
}