package me.aofz.acfb.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import me.aofz.acfb.repository.Repository
import me.aofz.acfb.repository.source.remote.AcnhService
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(service: AcnhService): Repository{
        return Repository(service)
    }

}