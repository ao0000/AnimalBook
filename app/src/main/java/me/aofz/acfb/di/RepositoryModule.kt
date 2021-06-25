package me.aofz.acfb.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.aofz.acfb.repository.Repository
import me.aofz.acfb.repository.RepositoryImpl
import me.aofz.acfb.repository.source.remote.AnimalService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        service: AnimalService
    ): Repository {
        return RepositoryImpl(service)
    }
}