package uz.xushnudbek.contactappcompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.xushnudbek.contactappcompose.utils.navigator.AppNavigator
import uz.xushnudbek.contactappcompose.utils.navigator.NavigationDispatcher
import uz.xushnudbek.contactappcompose.utils.navigator.NavigationHandler

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {
    @Binds
    fun bindAppNavigator(impl: NavigationDispatcher) : AppNavigator

    @Binds
    fun bindAppNavigatorHandler(impl: NavigationDispatcher): NavigationHandler
}