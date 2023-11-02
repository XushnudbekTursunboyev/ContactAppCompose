package uz.xushnudbek.contactappcompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import uz.xushnudbek.contactappcompose.presentation.add.AddDirection
import uz.xushnudbek.contactappcompose.presentation.add.AddDirectionImpl
import uz.xushnudbek.contactappcompose.presentation.edit.EditDirection
import uz.xushnudbek.contactappcompose.presentation.edit.EditDirectionImpl
import uz.xushnudbek.contactappcompose.presentation.main.MainDirection
import uz.xushnudbek.contactappcompose.presentation.main.MainDirectionImpl
import uz.xushnudbek.contactappcompose.utils.navigator.AppNavigator
import uz.xushnudbek.contactappcompose.utils.navigator.NavigationDispatcher
import uz.xushnudbek.contactappcompose.utils.navigator.NavigationHandler

@Module
@InstallIn(ViewModelComponent::class)
interface DirectionModule {
    @Binds
    fun bindMainDirection(impl: MainDirectionImpl): MainDirection

    @Binds
    fun bindInfoDirection(impl: AddDirectionImpl): AddDirection

    @Binds
    fun bindEditDirection(impl: EditDirectionImpl): EditDirection
}