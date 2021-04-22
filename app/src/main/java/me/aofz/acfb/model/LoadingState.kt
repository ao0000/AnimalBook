package me.aofz.acfb.model

sealed class LoadingState<out T> {
    data class Success<T>(val data: T) : LoadingState<T>()
    object Loading : LoadingState<Nothing>()
    data class Error(val exception: Exception) : LoadingState<Nothing>()
}