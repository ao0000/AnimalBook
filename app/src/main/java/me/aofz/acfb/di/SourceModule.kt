package me.aofz.acfb.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import me.aofz.acfb.repository.source.remote.AcnhService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object SourceModule {

    @Provides
    @Singleton
    fun provideJson(): Moshi {
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideService(moshi: Moshi): AcnhService {
        return Retrofit
            .Builder()
            .baseUrl("https://acnhapi.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(AcnhService::class.java)
    }

}