package me.aofz.acfb.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.aofz.acfb.repository.Repository
import me.aofz.acfb.repository.RepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBindModule {

    @Binds
    abstract fun bindRepository(
        repositoryImpl: RepositoryImpl
    ): Repository

}