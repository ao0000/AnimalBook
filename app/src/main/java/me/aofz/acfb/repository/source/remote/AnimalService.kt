package me.aofz.acfb.repository.source.remote

import me.aofz.acfb.model.FishEntity
import retrofit2.Response
import retrofit2.http.GET

interface AnimalService {
    @GET("v1a/fish")
    suspend fun getFishList(): Response<List<FishEntity>>
}