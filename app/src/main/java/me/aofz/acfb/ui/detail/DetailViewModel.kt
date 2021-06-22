package me.aofz.acfb.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.aofz.acfb.model.Animal
import me.aofz.acfb.model.AnimalType
import me.aofz.acfb.model.LoadingState
import me.aofz.acfb.repository.Repository
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _uiState: MutableStateFlow<LoadingState<Animal>> =
        MutableStateFlow(LoadingState.Loading)

    val uiState: StateFlow<LoadingState<Animal>>
        get() = _uiState

    fun fetchItem(animalType: AnimalType, animalId: Int) {
        viewModelScope.launch {
            when (animalType) {
                AnimalType.FISH -> {
                    repository.getFish(animalId).collect { viewState ->
                        _uiState.value = viewState
                    }
                }
                AnimalType.BUG -> {
                    repository.getBug(animalId).collect { viewState ->
                        _uiState.value = viewState
                    }
                }
                AnimalType.SEA_CREATURE -> {
                    repository.getSeaCreature(animalId).collect { viewState ->
                        _uiState.value = viewState
                    }
                }
            }
        }
    }
}