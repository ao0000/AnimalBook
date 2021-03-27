package me.aofz.acfb.repository.source.remote

import retrofit2.http.GET

interface AnimalService {
    @GET("v1a/fish")
    suspend fun getFishList(): List<FishEntity>
}