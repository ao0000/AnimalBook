package me.aofz.acfb.repository

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.aofz.acfb.model.Fish
import me.aofz.acfb.repository.source.remote.AcnhService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Repository {
    private val moshi = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val service = Retrofit
        .Builder()
        .baseUrl("https://acnhapi.com/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(AcnhService::class.java)

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