package me.aofz.acfb.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import me.aofz.acfb.model.Fish
import me.aofz.acfb.model.ResourceState
import me.aofz.acfb.repository.source.remote.AnimalService
import javax.inject.Inject
import javax.inject.Singleton

interface Repository {
    suspend fun getFishList(): Flow<ResourceState<List<Fish>>>
}

@Singleton
class RepositoryImpl @Inject constructor(private val service: AnimalService) : Repository {

    override suspend fun getFishList(): Flow<ResourceState<List<Fish>>> {
        return flow {
            emit(ResourceState.Loading)
            try {
                val response: List<Fish> = service.getFishList().map { it.toModel() }
                emit(ResourceState.Success(response))
            } catch (exception: Exception) {
                emit(ResourceState.Error(exception))
            }
        }.flowOn(Dispatchers.IO)
    }
}