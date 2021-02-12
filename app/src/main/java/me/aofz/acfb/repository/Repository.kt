package me.aofz.acfb.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.aofz.acfb.model.Fish
import me.aofz.acfb.repository.source.remote.AcnhService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val service: AcnhService) {

    suspend fun getFishList(): List<Fish> {
        return withContext(Dispatchers.IO) {
            service.getFishList().map {
                it.toFish()
            }
        }
    }

    suspend fun getFish(fishId: Int): Fish {
        return withContext(Dispatchers.IO) {
            service.getFish(fishId).toFish()
        }
    }

}