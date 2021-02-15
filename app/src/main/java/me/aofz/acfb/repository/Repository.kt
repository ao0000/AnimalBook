package me.aofz.acfb.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.aofz.acfb.model.Fish
import me.aofz.acfb.repository.source.local.FishDatabaseDAO
import me.aofz.acfb.repository.source.remote.AcnhService
import javax.inject.Inject
import javax.inject.Singleton

interface Repository {

    suspend fun getFishList(): List<Fish>

    suspend fun getFish(fishId: Int): Fish

}

@Singleton
class RepositoryImpl @Inject constructor(
    private val service: AcnhService,
    private val database: FishDatabaseDAO
) : Repository {

    override suspend fun getFishList(): List<Fish> {
        return withContext(Dispatchers.IO) {
            fetchFishList()
            database.getAllFishList().map {
                it.toFish()
            }
        }
    }


    override suspend fun getFish(fishId: Int): Fish {
        return withContext(Dispatchers.IO) {
            service.getFish(fishId).toFish()
        }
    }

    private suspend fun fetchFishList() {
        val fishEntityList = service.getFishList().map {
            it.toLocalEntity()
        }
        database.insertFishList(fishEntityList)
    }

}