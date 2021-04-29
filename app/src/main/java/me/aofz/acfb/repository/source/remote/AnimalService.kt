package me.aofz.acfb.repository.source.remote

import me.aofz.acfb.model.BugEntity
import me.aofz.acfb.model.FishEntity
import retrofit2.http.GET

interface AnimalService {
    @GET("v1a/fish")
    suspend fun getFishList(): List<FishEntity>

    @GET("v1a/bugs")
    suspend fun getBugList(): List<BugEntity>
}