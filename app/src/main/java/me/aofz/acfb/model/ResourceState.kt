package me.aofz.acfb.model

sealed class ResourceState<out T> {
    data class Success<T>(val data: T) : ResourceState<T>()
    object Loading : ResourceState<Nothing>()
    data class Error(val exception: Exception) : ResourceState<Nothing>()
}