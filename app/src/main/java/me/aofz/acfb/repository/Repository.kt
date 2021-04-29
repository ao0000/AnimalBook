package me.aofz.acfb.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import me.aofz.acfb.model.Bug
import me.aofz.acfb.model.Fish
import me.aofz.acfb.model.LoadingState
import me.aofz.acfb.repository.source.remote.AnimalService
import javax.inject.Inject
import javax.inject.Singleton

interface Repository {
    suspend fun getFishList(): Flow<LoadingState<List<Fish>>>

    suspend fun getBugList(): Flow<LoadingState<List<Bug>>>
}

@Singleton
class RepositoryImpl @Inject constructor(private val service: AnimalService) : Repository {

    override suspend fun getFishList(): Flow<LoadingState<List<Fish>>> {
        return flow {
            emit(LoadingState.Loading)
            try {
                val response: List<Fish> = service.getFishList().map { it.toModel() }
                emit(LoadingState.Success(response))
            } catch (exception: Exception) {
                emit(LoadingState.Error(exception))
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getBugList(): Flow<LoadingState<List<Bug>>> {
        return flow {
            emit(LoadingState.Loading)
            try {
                val response: List<Bug> = service.getBugList().map { it.toModel() }
                emit(LoadingState.Success(response))
            } catch (exception: Exception) {
                emit(LoadingState.Error(exception))
            }
        }.flowOn(Dispatchers.IO)
    }
}