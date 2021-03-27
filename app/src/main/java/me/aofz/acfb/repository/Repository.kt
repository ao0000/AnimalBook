package me.aofz.acfb.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import me.aofz.acfb.model.Resource
import me.aofz.acfb.repository.source.remote.AnimalService
import javax.inject.Inject
import javax.inject.Singleton

interface Repository {
    suspend fun getFishList(): Flow<Resource<*>>
}

@Singleton
class RepositoryImpl @Inject constructor(private val service: AnimalService) : Repository {

    override suspend fun getFishList(): Flow<Resource<*>> {
        return flow {
            val response = service.getFishList()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()?.let {
                    val fishListModel = it.map { entity -> entity.toModel() }
                    emit(Resource.Success(fishListModel))
                }
            } else {
                emit(Resource.Error(responseCode.toString(), null))
            }
        }.flowOn(Dispatchers.IO)
    }

}