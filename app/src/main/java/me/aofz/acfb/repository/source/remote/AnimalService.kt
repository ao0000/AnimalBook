package me.aofz.acfb.repository.source.remote

import me.aofz.acfb.model.BugEntity
import me.aofz.acfb.model.FishEntity
import me.aofz.acfb.model.SeaCreatureEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimalService {
    @GET("v1a/fish")
    suspend fun getFishList(): List<FishEntity>

    @GET("v1a/bugs")
    suspend fun getBugList(): List<BugEntity>

    @GET("v1a/sea")
    suspend fun getSeaCreatureList(): List<SeaCreatureEntity>

    @GET("v1/fish/{fish_id}")
    suspend fun getFishDetail(@Path("fish_id") fishId: Int): FishEntity

    @GET("v1/bugs/{bug_id}")
    suspend fun getBugDetail(@Path("bug_id") bugId: Int): BugEntity

    @GET("v1/sea/{sea_creature_id}")
    suspend fun getSeaCreatureDetail(@Path("sea_creature_id") seaCreatureId: Int): SeaCreatureEntity
}