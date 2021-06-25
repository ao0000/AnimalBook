package me.aofz.acfb.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import me.aofz.acfb.model.Bug
import me.aofz.acfb.model.Fish
import me.aofz.acfb.model.LoadingState
import me.aofz.acfb.model.SeaCreature
import me.aofz.acfb.repository.source.remote.AnimalService

interface Repository {
    suspend fun getFishList(): Flow<LoadingState<List<Fish>>>

    suspend fun getBugList(): Flow<LoadingState<List<Bug>>>

    suspend fun getSeaCreatureList(): Flow<LoadingState<List<SeaCreature>>>

    suspend fun getFish(fishId: Int): Flow<LoadingState<Fish>>

    suspend fun getBug(bugId: Int): Flow<LoadingState<Bug>>

    suspend fun getSeaCreature(seaCreatureId: Int): Flow<LoadingState<SeaCreature>>
}

class RepositoryImpl(
    private val service: AnimalService,
    private val ioDispatcher: CoroutineDispatcher
) : Repository {

    override suspend fun getFishList(): Flow<LoadingState<List<Fish>>> = flow {
        emit(LoadingState.Loading)
        try {
            val response: List<Fish> = service.getFishList().map { it.toModel() }
            emit(LoadingState.Success(response))
        } catch (exception: Exception) {
            emit(LoadingState.Error(exception))
        }
    }.flowOn(ioDispatcher)

    override suspend fun getBugList(): Flow<LoadingState<List<Bug>>> = flow {
        emit(LoadingState.Loading)
        try {
            val response: List<Bug> = service.getBugList().map { it.toModel() }
            emit(LoadingState.Success(response))
        } catch (exception: Exception) {
            emit(LoadingState.Error(exception))
        }
    }.flowOn(ioDispatcher)

    override suspend fun getSeaCreatureList(): Flow<LoadingState<List<SeaCreature>>> = flow {
        emit(LoadingState.Loading)
        try {
            val response: List<SeaCreature> = service.getSeaCreatureList().map { it.toModel() }
            emit(LoadingState.Success(response))
        } catch (exception: Exception) {
            emit(LoadingState.Error(exception))
        }
    }.flowOn(ioDispatcher)

    override suspend fun getFish(fishId: Int): Flow<LoadingState<Fish>> = flow {
        emit(LoadingState.Loading)
        try {
            val response: Fish = service.getFishDetail(fishId).toModel()
            emit(LoadingState.Success(response))
        } catch (exception: Exception) {
            emit(LoadingState.Error(exception))
        }
    }.flowOn(ioDispatcher)

    override suspend fun getBug(bugId: Int): Flow<LoadingState<Bug>> = flow {
        emit(LoadingState.Loading)
        try {
            val response: Bug = service.getBugDetail(bugId).toModel()
            emit(LoadingState.Success(response))
        } catch (exception: Exception) {
            emit(LoadingState.Error(exception))
        }
    }.flowOn(ioDispatcher)

    override suspend fun getSeaCreature(seaCreatureId: Int): Flow<LoadingState<SeaCreature>> =
        flow {
            emit(LoadingState.Loading)
            try {
                val response: SeaCreature = service.getSeaCreatureDetail(seaCreatureId).toModel()
                emit(LoadingState.Success(response))
            } catch (exception: Exception) {
                emit(LoadingState.Error(exception))
            }
        }.flowOn(ioDispatcher)
}