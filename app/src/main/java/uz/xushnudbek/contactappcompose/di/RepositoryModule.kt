package uz.xushnudbek.contactappcompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.xushnudbek.contactappcompose.domain.repository.AppRepository
import uz.xushnudbek.contactappcompose.domain.repository.impl.AppRepositoryImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {
    @[Binds Singleton]
    fun bindAppRepository(impl: AppRepositoryImpl): AppRepository
}