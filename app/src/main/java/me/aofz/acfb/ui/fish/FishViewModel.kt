package me.aofz.acfb.ui.fish

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.aofz.acfb.model.Fish
import me.aofz.acfb.model.LoadingState
import me.aofz.acfb.repository.Repository
import javax.inject.Inject

@HiltViewModel
class FishViewModel @Inject constructor(private val repository: Repository) :
    ViewModel() {

    private val _uiState: MutableStateFlow<LoadingState<List<Fish>>> =
        MutableStateFlow(LoadingState.Loading)

    val uiState: StateFlow<LoadingState<List<Fish>>>
        get() = _uiState

    init {
        viewModelScope.launch {
            repository.getFishList().collect { viewState ->
                _uiState.value = viewState
            }
        }
    }
}