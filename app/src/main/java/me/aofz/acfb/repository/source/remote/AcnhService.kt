package me.aofz.acfb.repository.source.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface AcnhService {
    @GET("v1a/fish")
    suspend fun getFishList():  List<FishEntity>

    @GET("v1/fish/{fishId}")
    suspend fun getFish(@Path("fishId") fishId: Int): FishEntity
}