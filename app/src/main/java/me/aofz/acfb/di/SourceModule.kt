package me.aofz.acfb.di

import android.content.Context
import coil.ImageLoader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.aofz.acfb.repository.source.remote.AnimalService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
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
    fun provideService(moshi: Moshi): AnimalService {
        return Retrofit
            .Builder()
            .baseUrl("https://acnhapi.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(AnimalService::class.java)
    }

    @Provides
    @Singleton
    fun provideImageLoader(@ApplicationContext context: Context): ImageLoader {
        return ImageLoader.Builder(context)
            .availableMemoryPercentage(0.25)
            .bitmapPoolPercentage(0.25)
            .build()
    }

}