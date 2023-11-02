package uz.xushnudbek.contactappcompose.presentation.main

import uz.xushnudbek.contactappcompose.data.ContactData
import uz.xushnudbek.contactappcompose.presentation.add.AddScreen
import uz.xushnudbek.contactappcompose.presentation.edit.EditScreen
import uz.xushnudbek.contactappcompose.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface MainDirection {
    suspend fun openAddScreen()
    suspend fun openEditScreen(contactData: ContactData)
}

@Singleton
class MainDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : MainDirection {
    override suspend fun openAddScreen() {
        appNavigator.openScreenSaveStack(AddScreen())
    }

    override suspend fun openEditScreen(contactData: ContactData) {
        appNavigator.openScreenSaveStack(EditScreen(contactData))
    }

}