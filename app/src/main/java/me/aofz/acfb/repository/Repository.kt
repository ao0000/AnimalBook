package me.aofz.acfb.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.aofz.acfb.model.Fish
import me.aofz.acfb.repository.source.remote.AnimalService
import javax.inject.Inject
import javax.inject.Singleton

interface Repository {
    suspend fun getFishList(): List<Fish>
}

@Singleton
class RepositoryImpl @Inject constructor(private val service: AnimalService) : Repository {

    override suspend fun getFishList(): List<Fish> {
        return withContext(Dispatchers.IO) {
            service.getFishList().map {
                it.toModel()
            }
        }
    }

}